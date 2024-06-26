package com.unpaz.reservas.dtos;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long idUsuario;
    private Long idContacto;
    private Long idRol;
    private String username;
    private String password;
}
