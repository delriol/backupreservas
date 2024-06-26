package com.unpaz.reservas.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ReservaDtoReq {
    @NotNull
    private Long idUsuario;
    private Long idCanchaPrecio ;
    private Long idHora;
    @DateTimeFormat
    private Date fecha;

    /*public ReservaDto(Reserva reserva){
        this.idReserva = reserva.getIdReserva();
        this.idUsuario = reserva.getUsu().getId_usuario();
        this.idCanchaPrecio = reserva.getCanchaPrecio().getIdCanchaPrecio();
        this.fecha = reserva.getFecha();
        this.idHora = reserva.getHora().getIdHora();
    }*/
}
