package com.projectSenasoft.volunteer.Services;


import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Repository.UsuarioRepository;
import com.projectSenasoft.volunteer.Services.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements Idao <UsuarioEntity, String> {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity getById(String idUsuario) {
        Optional<UsuarioEntity> optionalUsuarioEnity = usuarioRepository.findById(idUsuario);

        return optionalUsuarioEnity.orElse(null);
    }

    @Override
    public void update(UsuarioEntity entity) {
        usuarioRepository.save(entity);
    }

    @Override
    public void save(UsuarioEntity entity) {
        usuarioRepository.save(entity);
    }


    public void delete(String idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public void delete(UsuarioEntity entity) {
        usuarioRepository.delete(entity);
    }

    @Override
    public void create(UsuarioEntity entity) {

    }
}
