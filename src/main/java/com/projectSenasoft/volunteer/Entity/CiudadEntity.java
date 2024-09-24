package com.projectSenasoft.volunteer.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "ciudad")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CiudadEntity {

    @Id
    @Column(name = "id_ciudad")
    private String idCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    //fk departamento
    @ManyToOne(targetEntity = DepartamentoEntity.class)
    private List<DepartamentoEntity> departamento;
}
