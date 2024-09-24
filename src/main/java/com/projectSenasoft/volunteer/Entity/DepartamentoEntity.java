package com.projectSenasoft.volunteer.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    @Column(name = "id_departamento")
    private String idDepartamento;

    @Column(name = "nombre_departamento")
    private String nombreDepartamento;

    //Relation with pais
    @ManyToOne(targetEntity = PaisEntity.class)
    private List<PaisEntity> pais;

    //Relation with ciudad
    @OneToMany(targetEntity = CiudadEntity.class, fetch = FetchType.LAZY, mappedBy = "departamento")
    private List<CiudadEntity> ciudad;
}
