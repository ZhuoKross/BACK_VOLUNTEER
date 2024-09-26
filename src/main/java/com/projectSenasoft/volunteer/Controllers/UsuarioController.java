package com.projectSenasoft.volunteer.Controllers;

import com.projectSenasoft.volunteer.Business.UsuarioBusiness;
import com.projectSenasoft.volunteer.DTO.AssociateConvocatoriaDTO;
import com.projectSenasoft.volunteer.DTO.AssociateUserConvocatoriaDTO;
import com.projectSenasoft.volunteer.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioBusiness usuarioBusiness;


    @GetMapping("/all")
    public List<UsuarioDTO> findAll (){
        return usuarioBusiness.findAll();
    }

    @PostMapping("/create")
    public void create (@RequestBody UsuarioDTO usuarioDTO){
        System.out.println("EL usuario a ingresar es(Controller): " +  usuarioDTO);
        usuarioBusiness.create(usuarioDTO);
    }

    //ENDPOINT PARA ASOCIAR CONVOCATORIAS CON USERS
    @PostMapping("/associate")
    public void AssociateConvocatoria(@RequestBody AssociateUserConvocatoriaDTO associateUserConvocatoriaDTO){
        usuarioBusiness.AssociateConvocatoria(associateUserConvocatoriaDTO);
    }


    @PutMapping("/update/{id}")
    public  void update (@PathVariable("id") String idUsuario, @RequestBody UsuarioDTO usuarioDTO){
        usuarioBusiness.update(idUsuario, usuarioDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable String idUsuario){
        usuarioBusiness.delete(idUsuario);
    }

}
