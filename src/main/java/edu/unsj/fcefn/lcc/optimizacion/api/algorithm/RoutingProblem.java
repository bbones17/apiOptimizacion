package edu.unsj.fcefn.lcc.optimizacion.api.algorithm;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FrameDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.services.FramesService;
import edu.unsj.fcefn.lcc.optimizacion.api.services.StopsService;
import org.moeaframework.core.Solution;

import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.Permutation;
import org.moeaframework.problem.AbstractProblem;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Native;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RoutingProblem extends AbstractProblem {


    @Autowired
    StopsService stopsService;
    @Autowired
    FramesService framesService;

    List<StopDTO> stops;


    public RoutingProblem() {
        super(1, 2);
        this.stops = stopsService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(StopDTO::getRanking).reversed())
                .collect(Collectors.toList())
                .subList(0, 20);
    }

        @Override
        public void evaluate (Solution solution){
            solution.setObjective(0, totalPrice(solution.getVariable(0)));//calculo precio
            solution.setObjective(1, totalTime(solution.getVariable(0))); //calculo tiempo
        }

        private double totalPrice (Variable variable)
        {
            Permutation permutation = (Permutation) variable;

            double totalPrice = 0;
            for (int i = 0; i < permutation.size() - 1; i++) {
                StopDTO departuresStop = stops.get(permutation.get(i));
                StopDTO arrivalStop = stops.get(permutation.get(i + 1));
                List<FrameDTO> frames = framesService.findByIdDepartureStopAndArrivalStop(departuresStop.getId(), arrivalStop.getId());

                FrameDTO bestPriceFrame = frames
                        .stream()
                        .min(Comparator.comparing(FrameDTO::getPrice))
                        .orElse(null);


                if (Objects.isNull(bestPriceFrame)) {
                    return Double.MAX_VALUE;
                }
                totalPrice += bestPriceFrame.getPrice();
                //newSolution().addAttributes("Stop "+(i+1)+": " ,bestPriceFrame.getId());

            }


            return totalPrice;
        }

        private double totalTime (Variable variable)
        {
            Permutation permutation = (Permutation) variable;
            double totalTime = 0;

            for (int i = 0; i < permutation.size() - 1; i++) {
                StopDTO departuresStop = stops.get(permutation.get(i));
                StopDTO arrivalStop = stops.get(permutation.get(i + 1));

                List<FrameDTO> frames = framesService
                        .findByIdDepartureStopAndArrivalStop(departuresStop.getId(), arrivalStop.getId());

                Map<Integer, Long> mapTime = getTimeMaps(frames);
                Map.Entry<Integer, Long> frameIdTimeToArrival = mapTime
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue())
                        .orElse(null);


                if (Objects.isNull(frameIdTimeToArrival)) {
                    return Double.MAX_VALUE;
                }
                FrameDTO frameDTO = frames
                        .stream()
                        .filter(frame -> frame.getId().equals(frameIdTimeToArrival.getKey()))
                        .findFirst()
                        .orElse(null);

                if (Objects.isNull(frameDTO)) {
                    return Double.MAX_VALUE;
                }

                totalTime += frameIdTimeToArrival.getValue();

            }
            return totalTime;
        }


        private Map<Integer, Long> getTimeMaps (List < FrameDTO > frames)
        {
            Map<Integer, Long> mapTime = new HashMap<>();

            for (FrameDTO frame : frames) {
                if (frame.getDepartureDatetime().isBefore(frame.getArrivalDatetime())) {
                    Long timeToArrival = Duration.between(frame.getDepartureDatetime(), frame.getArrivalDatetime()).getSeconds();
                    mapTime.put(frame.getId(), timeToArrival);
                } else {
                    Long timeToArrivalRange1 = Duration.between(frame.getDepartureDatetime(), LocalTime.MIDNIGHT).getSeconds();
                    Long timeToArrivalRange2 = Duration.between(LocalTime.MIDNIGHT, frame.getArrivalDatetime()).getSeconds();
                    Long timeToArrival = timeToArrivalRange1 + timeToArrivalRange2;
                    mapTime.put(frame.getId(), timeToArrival);
                }
            }
            return mapTime;


            //tarea: hacer que el tiempo de salida del siguiente bondi sea entre hora de llegada y medianoche,
            // o sumar eso a la hora de salida a partir de la medianoche
        }

        @Override
        public Solution newSolution () {
            Solution solution = new Solution(1, 2);
            solution.setVariable(0, EncodingUtils.newPermutation(20));
            return solution;
        }


}