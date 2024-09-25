package com.projectSenasoft.volunteer.Services;

import com.projectSenasoft.volunteer.Entity.RolEntity;
import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Repository.RolRepository;
import com.projectSenasoft.volunteer.Services.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements Idao<RolEntity, String> {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public RolEntity getById(String idRol) {

        Optional<RolEntity> rolEntity = rolRepository.findById(idRol);

        return rolEntity.orElse(null);


    }

    @Override
    public void update(RolEntity rolEntity) {
        rolRepository.save(rolEntity);
    }

    @Override
    public void save(RolEntity rolEntity) {
        rolRepository.save(rolEntity);
    }


    @Override
    public void delete(RolEntity rol){
        rolRepository.delete(rol);
    }


    public void deleteOne(String idRol) {
        rolRepository.deleteById(idRol);
    }

    @Override
    public void create(RolEntity rolEntity) {
        rolRepository.save(rolEntity);
    }
}
