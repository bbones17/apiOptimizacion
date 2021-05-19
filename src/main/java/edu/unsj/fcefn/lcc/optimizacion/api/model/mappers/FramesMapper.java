package edu.unsj.fcefn.lcc.optimizacion.api.model.mappers;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FrameDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.FrameEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FramesMapper {
    public FrameDTO entityToDTO(FrameEntity frameEntity){
        FrameDTO frameDTO = new FrameDTO();

        frameDTO.setId(frameEntity.getId());
        frameDTO.setIdTransportCompany(frameEntity.getIdTransportCompany());
        frameDTO.setIdStopDeparture(frameEntity.getIdStopDeparture());
        frameDTO.setIdStopArrival(frameEntity.getIdStopArrival());
        frameDTO.setPrice(frameEntity.getPrice());
        frameDTO.setCategory(frameEntity.getCategory());
        frameDTO.setDepartureDatetime(frameEntity.getDepartureDatetime());
        frameDTO.setArrivalDatetime(frameEntity.getArrivalDatetime());
        return frameDTO;
    }

    public FrameEntity dtoToEntity(FrameDTO frameDTO){
       FrameEntity frameEntity = new FrameEntity();

       frameEntity.setId(frameDTO.getId());
       frameEntity.setIdTransportCompany(frameDTO.getIdTransportCompany());
       frameEntity.setIdStopDeparture(frameDTO.getIdStopDeparture());
       frameEntity.setIdStopArrival((frameDTO.getIdStopArrival()));
       frameEntity.setPrice(frameDTO.getPrice());
       frameEntity.setCategory(frameDTO.getCategory());
       frameEntity.setDepartureDatetime(frameDTO.getDepartureDatetime());
       frameEntity.setArrivalDatetime(frameDTO.getArrivalDatetime());
       return frameEntity;
    }
}