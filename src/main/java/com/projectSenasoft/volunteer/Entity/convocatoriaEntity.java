
package com.projectSenasoft.volunteer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "convocatoria")

public class convocatoriaEntity {

    @Id
    @Column(name = "id_convocatoria")
    private String idConvocatoria;

    @Column(name = "nombre_convocatoria")
    private String nombreConvocatoria;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    private String requisitos;

    @ManyToMany(targetEntity = CategoriaEntity.class, fetch =  FetchType.LAZY)
    @JoinTable(name = "convocatoria_categoria", joinColumns = @JoinColumn(name = "id_convocatoria"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<CategoriaEntity> categoria;
}
