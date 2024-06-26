package com.unpaz.reservas.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class ReservaDto {
    private Long idReserva;
    private Long idUsuario;
    private Long idCanchaPrecio ;
    private Date fecha;
    private Long idHora;
}
