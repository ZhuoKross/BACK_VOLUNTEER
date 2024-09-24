package com.projectSenasoft.volunteer.Business;

import com.projectSenasoft.volunteer.DTO.UsuarioDTO;
import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Repository.UsuarioRepository;
import com.projectSenasoft.volunteer.Services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioBusiness {

    @Autowired
    UsuarioService usuarioService;
    UsuarioRepository usuarioRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDTO> findAll(){
        try{
            List<UsuarioEntity> usuarioEntities= usuarioService.findAll();
            List<UsuarioDTO> usuarioDTOList = new ArrayList<>();

            for (UsuarioEntity usuario : usuarioEntities){
                usuarioDTOList.add(modelMapper.map(usuario, UsuarioDTO.class));
            }

            return usuarioDTOList;
        }catch (Exception e){
            throw new Error("Error al listar todos los usuarios", e);
        }
    }


    public void create(UsuarioDTO usuarioDTO){
        try{
            UsuarioEntity usuario = modelMapper.map(usuarioDTO, UsuarioEntity.class);
        }catch (Exception e){
            throw new Error("Error al crear usuario");
        }
    }

    public void update (String idUser, UsuarioDTO usuarioDTO){
        try {
            UsuarioEntity usuarioEncontrado = usuarioService.getById(idUser);


            usuarioEncontrado.setIdUsuario(usuarioDTO.getIdUsuario());
            usuarioEncontrado.setNombre(usuarioDTO.getNombre());
            usuarioEncontrado.setEmail(usuarioDTO.getEmail());
            usuarioEncontrado.setContraseña(usuarioDTO.getContraseña());
            usuarioEncontrado.setRol(usuarioDTO.getIdRol());
            usuarioEncontrado.setPais(usuarioDTO.getIdPais());

            usuarioService.update(usuarioEncontrado);



        }catch (Exception e){
            throw new Error("Error al actualizar usuario");
        }
    }

    public void delete(String idUsuario){
        try{

            usuarioService.delete(idUsuario);


        }catch (Exception e){
            throw new Error("Error al eliminar Usuario", e);
        }
    }
}
