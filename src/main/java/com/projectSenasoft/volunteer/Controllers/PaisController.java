package com.projectSenasoft.volunteer.Controllers;


import com.projectSenasoft.volunteer.Business.PaisBusiness;
import com.projectSenasoft.volunteer.DTO.PaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/paises", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class PaisController {
    @Autowired
    PaisBusiness paisBusiness;

    @GetMapping("/all")
    public List<PaisDTO> findAll(){
        return paisBusiness.findAll();
    }

    @GetMapping("/all/{id}")
    public PaisDTO finOne(@PathVariable("id") String idPais){
        PaisDTO paisDTO = paisBusiness.findOne(idPais);
        return paisDTO;
    }

    @PostMapping("/create")
    public void create (@RequestBody PaisDTO paisDTO){
        System.out.println("Controller: " + paisDTO);
        paisBusiness.create(paisDTO);
    }


    @PutMapping("/update/{id}")
    public void update (@PathVariable("id") String idPais, @RequestBody PaisDTO paisDTO){
        paisBusiness.update(idPais, paisDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String idPais){
        paisBusiness.delete(idPais);
    }
}
