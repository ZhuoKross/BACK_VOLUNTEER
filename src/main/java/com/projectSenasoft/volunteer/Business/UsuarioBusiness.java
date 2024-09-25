package com.projectSenasoft.volunteer.Business;

import com.projectSenasoft.volunteer.DTO.AssociateConvocatoriaDTO;
import com.projectSenasoft.volunteer.DTO.UsuarioDTO;
import com.projectSenasoft.volunteer.Entity.PaisEntity;
import com.projectSenasoft.volunteer.Entity.RolEntity;
import com.projectSenasoft.volunteer.Entity.UsuarioEntity;
import com.projectSenasoft.volunteer.Repository.PaisRepository;
import com.projectSenasoft.volunteer.Repository.UsuarioRepository;
import com.projectSenasoft.volunteer.Services.ConvocatoriaService;
import com.projectSenasoft.volunteer.Services.PaisService;
import com.projectSenasoft.volunteer.Services.RolService;
import com.projectSenasoft.volunteer.Services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioBusiness {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    PaisService paisService;
    @Autowired
    ConvocatoriaService convocatoriaService;
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

            System.out.println("Contenido del DTO: " + usuarioDTO);

            UsuarioEntity usuario = modelMapper.map(usuarioDTO, UsuarioEntity.class);


            System.out.println("El id a buscar es(pais):" + usuarioDTO.getIdPais());
            System.out.println("EL id a buscar es(rol): "+ usuarioDTO.getIdRol());

            PaisEntity pais = paisService.getById(usuarioDTO.getIdPais());
            RolEntity rol = rolService.getById(usuarioDTO.getIdRol());



            usuario.setRol(rol);
            usuario.setPais(pais);

            usuarioService.save(usuario);
        }catch (Exception e){
            throw new Error("Error al crear usuario", e);
        }
    }


    public void AssociateConvocatoria(AssociateConvocatoriaDTO associateConvocatoriaDTO){
        try {

            UsuarioEntity usuario= usuarioService.getById(associateConvocatoriaDTO.getIdUsuario());
            convocatoriaEntity convocatoria = convocatoriaService.getById(associateConvocatoriaDTO.getIdConvocatoria());

            usuario.getIdRegistroConvocatoria().add(convocatoria);

            usuarioService.save(usuario);



        }catch (Exception e){
            throw new Error("Error al registrar convocatoria");
        }
    }

    public void update (String idUser, UsuarioDTO usuarioDTO){
        try {
            UsuarioEntity usuarioEncontrado = usuarioService.getById(idUser);

            PaisEntity pais = paisService.getById(usuarioDTO.getIdPais());
            RolEntity rol = rolService.getById(usuarioDTO.getIdRol());


            usuarioEncontrado.setIdUsuario(usuarioDTO.getIdUsuario());
            usuarioEncontrado.setNombre(usuarioDTO.getNombre());
            usuarioEncontrado.setEmail(usuarioDTO.getEmail());
            usuarioEncontrado.setContraseña(usuarioDTO.getContraseña());

            usuarioEncontrado.setRol(rol);
            usuarioEncontrado.setPais(pais);

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
