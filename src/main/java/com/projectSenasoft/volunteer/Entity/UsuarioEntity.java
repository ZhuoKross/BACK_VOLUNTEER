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
@Table(name = "Usuarios")
public class UsuarioEntity {

    @Id
    private String idUsuario;

    private String nombre;
    private String email;
    private String contraseña;

    @ManyToMany(targetEntity = convocatoriaEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "registro_convocatoria", joinColumns = @JoinColumn(name = "fk_id_usuario"), inverseJoinColumns = @JoinColumn(name = "fk_id_convocatoria"))
    private List<convocatoriaEntity> idRegistroConvocatoria;


    @ManyToOne(targetEntity = RolEntity.class)
    private String rol;

    @ManyToOne(targetEntity = PaisEntity.class)
    private String pais;

}
