package com.projectSenasoft.volunteer.Entity;


import com.projectSenasoft.volunteer.DTO.ConvocatoriaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @Column(name = "id_categoria")
    private String idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;


    @ManyToMany(mappedBy = "categorias")
    private List<convocatoriaEntity> convocatorias;

}
