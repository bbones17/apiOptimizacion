package edu.unsj.fcefn.lcc.optimizacion.api.services;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.StopEntity;
import edu.unsj.fcefn.lcc.optimizacion.api.model.mappers.StopsMapper;
import edu.unsj.fcefn.lcc.optimizacion.api.model.repositories.StopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StopsService {

    @Autowired
    StopsRepository stopsRepository;

    @Autowired
    StopsMapper stopsMapper;

    public List<StopDTO> findAll(){
        return stopsRepository
                .findAll()
                .stream()
                .map(stopEntity -> stopsMapper.entityToDTO(stopEntity))
                .collect(Collectors.toList());
    }

    public StopDTO find(Integer id){
        return stopsRepository
                .findById(id)
                .map(stopEntity -> stopsMapper.entityToDTO(stopEntity))
                .orElse(null);
    }

    public StopDTO add(StopDTO stopDTO){
        StopEntity stopEntity = stopsMapper.dtoToEntity(stopDTO);
        stopEntity = stopsRepository.save(stopEntity);
        return stopsMapper.entityToDTO(stopEntity);
    }

    public StopDTO edit(StopDTO stopDTO){
        StopEntity stopEntity = stopsMapper.dtoToEntity(stopDTO);
        stopEntity = stopsRepository.save(stopEntity);
        return stopsMapper.entityToDTO(stopEntity);
    }

    public StopDTO delete(Integer id) throws Exception {
        Optional<StopEntity> stopEntityOptional = stopsRepository.findById(id);
        if(stopEntityOptional.isPresent()){
            stopsRepository.deleteById(id);
            return stopsMapper.entityToDTO(stopEntityOptional.get());
        } else {
            throw new Exception("Stop not found");
        }
    }

}