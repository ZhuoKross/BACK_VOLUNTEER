package com.projectSenasoft.volunteer.Business;


import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import com.projectSenasoft.volunteer.DTO.ConvocatoriaDTO;
import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;
import com.projectSenasoft.volunteer.Services.CategoriaService;
import com.projectSenasoft.volunteer.Services.ConvocatoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvocatoriaBusiness {

    @Autowired
    ConvocatoriaService convocatoriaService;
    @Autowired
    CategoriaService categoriaService;
    ModelMapper modelMapper = new ModelMapper();

    public List<ConvocatoriaDTO> findAll(){
        try {
            List<convocatoriaEntity> convocatoriaEntities = convocatoriaService.findAll();
            List<ConvocatoriaDTO> convocatoriaDTOList = new ArrayList<>();

            for (convocatoriaEntity convocatoria : convocatoriaEntities){
                convocatoriaDTOList.add(modelMapper.map(convocatoria, ConvocatoriaDTO.class));
            }

            return convocatoriaDTOList;
        }catch (Exception e){
            throw new Error("Error al obtener convocatorias", e);
        }

    }

    public List<CategoriaDTO> findAssoicatedCategory(String id){
        try{

            List<CategoriaEntity> categoriaEntities = convocatoriaService.findAssociatedCategory(id);
            List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

            for (CategoriaEntity categoria : categoriaEntities){
                categoriaDTOS.add(modelMapper.map(categoria, CategoriaDTO.class));
            }

            return categoriaDTOS;

        }catch (Exception e){
            throw new Error("Error al obtener categoria asociada", e);
        }
    }


    public void create(ConvocatoriaDTO convocatoriaDTO){
        try {
            CategoriaEntity categoria = categoriaService.getById(convocatoriaDTO.getIdCategoria());

            convocatoriaEntity convocatoria = convocatoriaService.getById(convocatoriaDTO.getIdConvocatoria());

//            convocatoriaEntity convocatoria = modelMapper.map(convocatoriaDTO, convocatoriaEntity.class);

            convocatoria.getCategoria().add(categoria);

            convocatoriaService.save(convocatoria);

        }catch (Exception e){
            throw new Error("Error al crear categoria", e);
        }
    }


    public void update(String idConvocatoria, ConvocatoriaDTO convocatoriaDTO){
        try {

            convocatoriaEntity convocatoria = convocatoriaService.getById(idConvocatoria);
            CategoriaEntity categoria = categoriaService.getById(convocatoriaDTO.getIdCategoria());

            convocatoria.setIdConvocatoria(convocatoriaDTO.getIdConvocatoria());
            convocatoria.setNombreConvocatoria(convocatoriaDTO.getNombreConvocatoria());
            convocatoria.setFechaInicio(convocatoriaDTO.getFechaInicio());
            convocatoria.setFechaFinal(convocatoriaDTO.getFechaFinal());
            convocatoria.setRequisitos(convocatoriaDTO.getRequisitos());

            convocatoria.getCategoria().add(categoria);

            convocatoriaService.save(convocatoria);


        }catch (Exception e){
            throw new Error("Error al actualizar la convocatoria");
        }

    }

    public void delete(String idConvocatoria){
        try {

            convocatoriaService.deleteOne(idConvocatoria);

        }catch (Exception e){
            throw new Error("Error al eliminar convocatoria", e);
        }
    }

}
