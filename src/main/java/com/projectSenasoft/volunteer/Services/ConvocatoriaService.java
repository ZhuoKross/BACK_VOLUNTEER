package com.projectSenasoft.volunteer.Services;

import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;
import com.projectSenasoft.volunteer.Repository.ConvocatoriaRepository;
import com.projectSenasoft.volunteer.Services.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConvocatoriaService  implements Idao<convocatoriaEntity, String> {

    @Autowired
    ConvocatoriaRepository convocatoriaRepository;

    @Override
    public List<convocatoriaEntity> findAll() {

        return convocatoriaRepository.findAll();

    }

    @Override
    public convocatoriaEntity getById(String idConvocatoria) {

        Optional<convocatoriaEntity> convocatoriaEntity = convocatoriaRepository.findById(idConvocatoria);

        return convocatoriaEntity.orElse(null);
    }

    //MÉTODO PARA ENCONTRAR CATEGORIA ASOCIADA
    public List<CategoriaEntity> findAssociatedCategory (String idConvocatoria){

        List<CategoriaEntity> categoriaEntities = convocatoriaRepository.findAssociatedCategory(idConvocatoria);




        System.out.println("(Service Las categorias son)" +categoriaEntities);

        return categoriaEntities;


    }

    @Override
    public void update(convocatoriaEntity entity) {
        convocatoriaRepository.save(entity);
    }

    @Override
    public void save(convocatoriaEntity entity) {
        convocatoriaRepository.save(entity);

    }

    @Override
    public void delete(convocatoriaEntity entity) {
        convocatoriaRepository.delete(entity);
    }

    //MÉTODO DELETE PARA ELIMINAR EN BASE A UN ID
    public void deleteOne(String idConvocatoria){
        convocatoriaRepository.deleteById(idConvocatoria);
    }

    @Override
    public void create(convocatoriaEntity entity) {
        convocatoriaRepository.save(entity);
    }


}
