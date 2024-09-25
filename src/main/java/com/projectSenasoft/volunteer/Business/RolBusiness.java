package com.projectSenasoft.volunteer.Business;

import com.projectSenasoft.volunteer.DTO.RolDTO;
import com.projectSenasoft.volunteer.Entity.RolEntity;
import com.projectSenasoft.volunteer.Services.RolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolBusiness {

    @Autowired
    RolService rolService;
    ModelMapper modelMapper = new ModelMapper();

    public List<RolDTO> findAll(){
        try{

            List<RolEntity> rolEntityList = rolService.findAll();
            List<RolDTO> rolDTOList = new ArrayList<>();

            for (RolEntity rol : rolEntityList){
                rolDTOList.add(modelMapper.map(rol, RolDTO.class));
            }

            return rolDTOList;

        }catch (Exception e){
            throw new Error("Error al listar roles");
        }
    }

    public void create(RolDTO rolDTO){
        try {


            RolEntity rol = modelMapper.map(rolDTO, RolEntity.class);

            rolService.create(rol);

        }catch (Exception e){
            throw new Error("Error al crear Rol");
        }
    }


    public void update(String idRol, RolDTO rolDTO){
        try {

            RolEntity rol = rolService.getById(idRol);

            rol.setIdRol(rolDTO.getIdRol());
            rol.setNombreRol(rolDTO.getNombreRol());

            rolService.update(rol);

        }
        catch (Exception e){
            throw new Error("Error al Actualizar Rol");
        }
    }

    public void delete (String idRol){
        try {

            rolService.deleteOne(idRol);

        }catch (Exception e){
            throw new Error("Error al eliminar rol");
        }
    }
}
