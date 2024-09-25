package com.projectSenasoft.volunteer.Business;

import com.projectSenasoft.volunteer.DTO.PaisDTO;
import com.projectSenasoft.volunteer.Entity.PaisEntity;
import com.projectSenasoft.volunteer.Services.PaisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class PaisBusiness {

    @Autowired
    PaisService paisService;
    ModelMapper modelMapper = new ModelMapper();

    public List<PaisDTO> findAll(){
        try {

            List<PaisEntity> paisEntity = paisService.findAll();
            List<PaisDTO> paisDTOList = new ArrayList<>();

            for (PaisEntity pais : paisEntity){
                paisDTOList.add(modelMapper.map(pais, PaisDTO.class));
            }

            return paisDTOList;


        }catch (Exception e){
            throw new Error("Error al listar paises");
        }
    }


    public PaisDTO findOne(String idPais){
        try{

            PaisEntity pais = paisService.getById(idPais);

            PaisDTO newPais = modelMapper.map(pais, PaisDTO.class);

            return newPais;

        }catch (Exception e){
            throw new Error("Error al seleccionar uno: " , e);
        }
    }

    public void create(PaisDTO paisDTO){
        try {
            PaisEntity paisEntity = modelMapper.map(paisDTO, PaisEntity.class);

            System.out.println("el pais es: " + paisDTO);
            paisService.create(paisEntity);

        }catch (Exception e){
            throw new Error("Error al crear pais");
        }
    }


    public void update(String idPais, PaisDTO paisDTO){
        try {

            PaisEntity paisEntity = paisService.getById(idPais);

            paisEntity.setIdPais(paisDTO.getIdPais());
            paisEntity.setNombrePais(paisDTO.getNombrePais());


            paisService.update(paisEntity);

        }catch (Exception e){
            throw new Error("Error en la actualización de País");
        }
    }


    public void delete(String idPais){
        try {

            paisService.delete(idPais);

        }catch (Exception e){
            throw new Error("Error al eliminar pais");
        }
    }
}
