package com.projectSenasoft.volunteer.Entity;


import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Rol")
public class RolEntity {

    @Id
    @Column(name = "id_rol")
    private String idRol;

    @Column(name = "descripcion_rol")
    private String nombreRol;


    @OneToMany(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, mappedBy = "rol")
    private List<UsuarioEntity> usuarios;


}
