package com.projectSenasoft.volunteer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String idUsuario;
    private String nombre;
    private String email;
    private String contraseña;
    private String idRol;
    private String idPais;

}
