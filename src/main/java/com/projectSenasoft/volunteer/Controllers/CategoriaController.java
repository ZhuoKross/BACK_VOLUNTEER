package com.projectSenasoft.volunteer.Controllers;


import com.projectSenasoft.volunteer.Business.CategoriaBusiness;
import com.projectSenasoft.volunteer.DTO.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categorias", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @GetMapping("/all")
    public List<CategoriaDTO> findAll(){
        return categoriaBusiness.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody CategoriaDTO categoriaDTO){
        categoriaBusiness.create(categoriaDTO);
    }


    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String idCategoria, @RequestBody CategoriaDTO categoriaDTO){
        categoriaBusiness.update(idCategoria, categoriaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String idCategoria){
        categoriaBusiness.delete(idCategoria);
    }

}
