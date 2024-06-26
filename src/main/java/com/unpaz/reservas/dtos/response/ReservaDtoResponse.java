package com.unpaz.reservas.dtos.response;

import com.unpaz.reservas.model.Reserva;
import lombok.Data;

import java.util.Date;
@Data
public class ReservaDtoResponse {
    private Long idReserva;
    private Long idUsuario;
    private Long idCanchaPrecio ;
    private Date fecha;
    private Long idHora;

    public ReservaDtoResponse(Reserva res) {
        this.idReserva = res.getIdReserva();
        this.idUsuario = res.getUsu().getIdUsuario();
        this.idCanchaPrecio = res.getCanchaPrecio().getIdCanchaPrecio();
        this.fecha = res.getFecha();
        this.idHora = res.getHora().getIdHora();
    }
}
