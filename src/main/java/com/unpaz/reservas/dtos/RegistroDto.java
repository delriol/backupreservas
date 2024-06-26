package com.unpaz.reservas.dtos;

import lombok.Data;

@Data
public class RegistroDto {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private String email;
    private String nTelefono;
}
/*Página registro:  Nombre y Apellido, nombreusuario, contraseña, email y numero de teleofno
(verifica lógica de errores o que el nombre de usuario y/o mail no esté en uso)*/
