package com.projectSenasoft.volunteer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvocatoriaDTO {

    private String idConvocatoria;
    private String nombreConvocatoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String requisitos;
}
