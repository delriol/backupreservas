package com.unpaz.reservas.service;

import com.unpaz.reservas.dtos.ReservaDto;
import com.unpaz.reservas.dtos.request.ReservaDtoReq;
import com.unpaz.reservas.dtos.response.ReservaDtoResponse;
import com.unpaz.reservas.generic.CrudGeneric;
import com.unpaz.reservas.model.Hora;
import com.unpaz.reservas.model.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservaService extends CrudGeneric<Reserva, Long> {
    ReservaDtoResponse guardar(ReservaDtoReq obj);
    List<Hora> listarHorasLibres(Date Fecha);
    ReservaDtoResponse actualizar(ReservaDto obj);
}
