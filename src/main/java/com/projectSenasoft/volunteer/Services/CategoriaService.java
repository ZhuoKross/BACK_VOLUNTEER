package com.projectSenasoft.volunteer.Services;


import com.projectSenasoft.volunteer.Entity.CategoriaEntity;
import com.projectSenasoft.volunteer.Repository.CategoriaRepository;
import com.projectSenasoft.volunteer.Services.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService  implements Idao<CategoriaEntity, String> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity getById(String idCategoria) {
        Optional<CategoriaEntity> categoria = categoriaRepository.findById(idCategoria);
        return categoria.orElse(null);
    }

    @Override
    public void update(CategoriaEntity entity) {
        categoriaRepository.save(entity);
    }

    @Override
    public void save(CategoriaEntity entity) {
        categoriaRepository.save(entity);
    }

    @Override
    public void delete(CategoriaEntity entity) {
        categoriaRepository.delete(entity);
    }

    public void deleteOne(String idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }

    @Override
    public void create(CategoriaEntity entity) {

    }
}
