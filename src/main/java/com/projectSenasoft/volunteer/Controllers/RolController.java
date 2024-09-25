package com.projectSenasoft.volunteer.Controllers;

import com.projectSenasoft.volunteer.Business.RolBusiness;
import com.projectSenasoft.volunteer.DTO.RolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roles", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    RolBusiness rolBusiness;

    @GetMapping("/all")
    public List<RolDTO> findAll(){
        return rolBusiness.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody RolDTO rolDTO){
        rolBusiness.create(rolDTO);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String idRol, @RequestBody RolDTO rolDTO ){
        rolBusiness.update(idRol, rolDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String idRol){
        rolBusiness.delete(idRol);
    }
}
