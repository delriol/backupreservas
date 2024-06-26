package com.unpaz.reservas.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRegistroDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String  nombre;
    @NotNull
    private String  apellido;
    private String  userName;
    @Email
    private String  mail;
    private String  numeroTelefono;
    private String  password;
}