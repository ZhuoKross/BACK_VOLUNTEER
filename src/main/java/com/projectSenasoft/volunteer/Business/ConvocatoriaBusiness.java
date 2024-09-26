package com.projectSenasoft.volunteer.Business;


import com.projectSenasoft.volunteer.DTO.AssociateConvocatoriaDTO;
import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import com.projectSenasoft.volunteer.DTO.ConvocatoriaDTO;
import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;
import com.projectSenasoft.volunteer.Services.CategoriaService;
import com.projectSenasoft.volunteer.Services.ConvocatoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponseException;

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

            System.out.println("Business: " + id);
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

            System.out.println("Contenido: " + convocatoriaDTO);

            System.out.println("El id de la categoria es: " + convocatoriaDTO.getIdCategoria());
            CategoriaEntity categoria = categoriaService.getById(convocatoriaDTO.getIdCategoria());

            System.out.println("El id de la convocatoria a buscar es: " + convocatoriaDTO.getIdConvocatoria());
            convocatoriaEntity convocatoria = convocatoriaService.getById(convocatoriaDTO.getIdConvocatoria());
            //System.out.println("La entidad de convocatoria es: " + convocatoria);

            if(categoria == null){
                throw new Error("La categoria no existe");
            }


            if (convocatoria == null){
                convocatoriaEntity newConvocatoria = new convocatoriaEntity();

                newConvocatoria.setIdConvocatoria(convocatoriaDTO.getIdConvocatoria());
                newConvocatoria.setNombreConvocatoria(convocatoriaDTO.getNombreConvocatoria());
                newConvocatoria.setFechaInicio(convocatoriaDTO.getFechaInicio());
                newConvocatoria.setFechaFinal(convocatoriaDTO.getFechaFinal());
                newConvocatoria.setRequisitos(convocatoriaDTO.getRequisitos());

                newConvocatoria.getCategorias().add(categoria);

                convocatoriaService.save(newConvocatoria);


            }else {
                convocatoria.getCategorias().add(categoria);
                convocatoriaService.save(convocatoria);
            }



        }catch (Exception e){
            throw new Error("Error al crear convocatoria", e);
        }
    }


    // METODO PARA AGREGAR CATEGORIAS A LA CONVOCATORIA
    public void addCategory(AssociateConvocatoriaDTO associateConvocatoriaDTO){
        try {

            String idConvocatoria = associateConvocatoriaDTO.getIdConvocatoria();
            String idCategoria = associateConvocatoriaDTO.getIdCategoria();


            System.out.println("El id de la convocatoria es: " + idConvocatoria);
            System.out.println("El id de la categoria es: " + idCategoria);

            convocatoriaEntity convocatoria = convocatoriaService.getById(idConvocatoria);

            CategoriaEntity categoria = categoriaService.getById(idCategoria);

            if(convocatoria == null){
                throw new Error("La convocatoria no existe");
            }

            if(categoria == null){
                throw new Error("La categoria no existe");
            }

            convocatoria.getCategorias().add(categoria);

            convocatoriaService.save(convocatoria);


        }catch (Exception e){
            throw new Error("Error al agregar categoria", e);
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

            convocatoria.getCategorias().add(categoria);

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

    //MÉTODO PARA ELIMINAR CATEGORIA DE UNA CONVOCATORIA
    /*public void deleteCategory(AssociateConvocatoriaDTO associateConvocatoriaDTO){
        try {

            String idConvocatoria = associateConvocatoriaDTO.getIdConvocatoria();
            String idCategoria = associateConvocatoriaDTO.getIdCategoria();



            convocatoriaService.del


        }catch (Exception e){
            throw new Error("Error al eliminar categoria");
        }
    }*/

}
