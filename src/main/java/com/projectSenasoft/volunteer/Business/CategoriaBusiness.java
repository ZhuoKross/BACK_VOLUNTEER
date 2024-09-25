package com.projectSenasoft.volunteer.Business;


import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import com.projectSenasoft.volunteer.Services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaBusiness {
    @Autowired
    CategoriaService categoriaService;
    ModelMapper modelMapper = new ModelMapper();

    public List<CategoriaDTO> findAll(){
        try {
            List<CategoriaEntity> categoriaEntities = categoriaService.findAll();
            List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

            for (CategoriaEntity categoria : categoriaEntities){
                categoriaDTOS.add(modelMapper.map(categoria, CategoriaDTO.class));
            }

            return categoriaDTOS;


        }catch (Exception e){
            throw new Error("Error al obtener categorias", e);
        }
    }



    public void create(CategoriaDTO categoriaDTO){
        try{

            CategoriaEntity categoria = modelMapper.map(categoriaDTO, CategoriaEntity.class);

            categoriaService.save(categoria);

        }catch (Exception e){
            throw new Error("Error al crear categoria");
        }
    }


    public void update(String idCategoria, CategoriaDTO categoriaDTO){
        try {

            CategoriaEntity categoria = categoriaService.getById(idCategoria);

            categoria.setIdCategoria(categoriaDTO.getIdCategoria());
            categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());

            categoriaService.update(categoria);

        }catch (Exception e){
            throw new Error("Error al actualizar categoria");
        }
    }

    public void delete(String idCategoria){
        try {

            categoriaService.deleteOne(idCategoria);

        }catch (Exception e){
            throw new Error("Error al eliminar categoria", e);
        }
    }
}
