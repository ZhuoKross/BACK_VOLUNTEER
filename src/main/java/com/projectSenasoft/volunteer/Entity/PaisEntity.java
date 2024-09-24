package com.projectSenasoft.volunteer.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="Pais")
public class PaisEntity {

    @Id
    @Column(name = "id_pais")
    private String idPais;

    @Column(name = "nombre_pais")
    private String nombrePais;

    @OneToMany(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, mappedBy = "pais")
    private List<UsuarioEntity> usuarios;

    @OneToMany(targetEntity = DepartamentoEntity.class, fetch = FetchType.LAZY, mappedBy = "pais")
    private List<DepartamentoEntity> departamento;


}
