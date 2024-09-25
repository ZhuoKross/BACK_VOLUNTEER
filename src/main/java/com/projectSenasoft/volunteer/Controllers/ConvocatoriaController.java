package com.projectSenasoft.volunteer.Controllers;

import com.projectSenasoft.volunteer.Business.ConvocatoriaBusiness;
import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import com.projectSenasoft.volunteer.DTO.ConvocatoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projectSenasoft.volunteer.Entity.convocatoriaEntity;

import java.util.List;

@RestController
@RequestMapping(path = "/convocatorias", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class ConvocatoriaController {

    @Autowired
    ConvocatoriaBusiness convocatoriaBusiness;

    @GetMapping("/all")
    public List<ConvocatoriaDTO> findAll(){

        List<ConvocatoriaDTO> convocatoriaDTOList = convocatoriaBusiness.findAll();

        System.out.println(convocatoriaDTOList);

        return convocatoriaDTOList;
    }

    @GetMapping("/fetchcategorys/{id}")
    public List<CategoriaDTO> fetchCategorys(@PathVariable("id") String idConvocatoria){


        List<CategoriaDTO> categoriaDTOS = convocatoriaBusiness.findAssoicatedCategory(idConvocatoria);

        System.out.println("objeto controller: " + categoriaDTOS);

        return categoriaDTOS;
    }


    @PostMapping("/create")
    public void create(@RequestBody ConvocatoriaDTO convocatoriaDTO){
        convocatoriaBusiness.create(convocatoriaDTO);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String idConvocatoria, @RequestBody ConvocatoriaDTO convocatoriaDTO){
        convocatoriaBusiness.update(idConvocatoria, convocatoriaDTO);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String idConvocatoria){
        convocatoriaBusiness.delete(idConvocatoria);
    }
}
