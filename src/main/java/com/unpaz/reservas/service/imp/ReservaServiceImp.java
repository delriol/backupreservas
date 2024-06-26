package com.unpaz.reservas.service.imp;

import com.unpaz.reservas.dtos.ReservaDto;
import com.unpaz.reservas.dtos.request.ReservaDtoReq;
import com.unpaz.reservas.dtos.response.ReservaDtoResponse;
import com.unpaz.reservas.exeptions.NotFoundException;
import com.unpaz.reservas.model.Hora;
import com.unpaz.reservas.model.Reserva;
import com.unpaz.reservas.repository.*;
import com.unpaz.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImp implements ReservaService {
    /*@Override
    public Reserva save(Reserva obj) {
        return null;
    }*/

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HoraRepository horaRepository;
    @Autowired
    private CanchaPrecioRepository canchaPrecioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
//validar si no esta ocupada la hora y dia

    @Override
    public ReservaDtoResponse guardar(ReservaDtoReq obj) {
        Reserva reservaNueva = new Reserva();
        reservaNueva.setHora(horaRepository.findById(obj.getIdHora()).orElseThrow(() ->
                new NotFoundException("No se encontro razon social con el id: " + obj.getIdHora() )));
        reservaNueva.setCanchaPrecio(canchaPrecioRepository.findById(obj.getIdCanchaPrecio()).orElseThrow(() ->
                new NotFoundException("No se Id CAnchaPrecio con el id: " + obj.getIdCanchaPrecio() )));
        reservaNueva.setUsu(usuarioRepository.findById(obj.getIdUsuario()).orElseThrow(() ->
                new NotFoundException("No se encontro Usuario con el id: " + obj.getIdUsuario() )));
        reservaNueva.setFecha(obj.getFecha());
        ReservaDtoResponse reser = new ReservaDtoResponse(reservaRepository.save(reservaNueva));
        return reser;
        /*ReservaDtoResponse reser = new ReservaDtoResponse(reservaNueva);
        reservaRepository.save(reservaNueva);
        return reser;*/
    }



    /*@Override
    public ReservaDtoResponse guardar(ReservaDto obj) {
        Reserva reservaNueva = new Reserva();
        reservaNueva = reservaRepository.findById(obj.getIdReserva()).orElseThrow(() ->
                new NotFoundException("No se encontro razon social con el id: " + obj.getIdReserva() ));
        reservaNueva.setHora(horaRepository.findById(obj.getIdHora()).orElseThrow(() ->
                new NotFoundException("No se encontro razon social con el id: " + obj.getIdHora() )));
        reservaNueva.setCanchaPrecio(canchaPrecioRepository.findById(obj.getIdCanchaPrecio()).orElseThrow(() ->
                new NotFoundException("No se Id CAnchaPrecio con el id: " + obj.getIdCanchaPrecio() )));
        reservaNueva.setUsu(usuarioRepository.findById(obj.getIdUsuario()).orElseThrow(() ->
                new NotFoundException("No se encontro Usuario con el id: " + obj.getIdUsuario() )));
        ReservaDtoResponse reser = new ReservaDtoResponse(reservaNueva);
        reservaRepository.save(reservaNueva);
        return reser;
    }*/

/*
    @Override
    public Reserva save(Reserva obj) {
        Reserva reservaNueva = new Reserva();
        reservaNueva.setFecha(obj.getFecha());
        reservaNueva.setHora(horaRepository.findById(obj.getIdHora()).orElseThrow(() ->
                new NotFoundException("No se encontro razon social con el id: " + obj.getIdHora() )));
        reservaNueva.setCanchaPrecio(canchaPrecioRepository.findById(obj.getIdCanchaPrecio()).orElseThrow(() ->
                new NotFoundException("No se Id CAnchaPrecio con el id: " + obj.getIdCanchaPrecio() )));
        reservaNueva.setUsu(usuarioRepository.findById(obj.getIdUsuario()).orElseThrow(() ->
                new NotFoundException("No se encontro Usuario con el id: " + obj.getIdUsuario() )));
        //ReservaDtoResponse reser = new ReservaDtoResponse(reservaNueva);
        return reservaRepository.save(reservaNueva);
    }*/

    @Override
    public List<Hora> listarHorasLibres(Date fecha) {
        return horaRepository.findAvailableHorasByFecha(fecha);
    }

    @Override
    public ReservaDtoResponse actualizar(ReservaDto obj) {

        Reserva reservaModificada = reservaRepository.findById(obj.getIdReserva()).orElseThrow(() ->
                new NotFoundException("No se encontro Reserva con el id: " + obj.getIdReserva() ));
        reservaModificada.setIdReserva(obj.getIdReserva());
        reservaModificada.setUsu(usuarioRepository.findById(obj.getIdUsuario()).orElseThrow(() ->
                new NotFoundException("No se encontro Reserva con el id usuario: " + obj.getIdUsuario())));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatoFechaObj = sdf.format(obj.getFecha());
        String formatoFechaReserva = sdf.format(reservaModificada.getFecha());

        if (!formatoFechaObj.equals(formatoFechaReserva)) {
            reservaModificada.setFecha(obj.getFecha());
        }
        //reservaModificada.setFecha(obj.getFecha());
        reservaModificada.setHora(horaRepository.findById(obj.getIdHora()).orElseThrow(() ->
                new NotFoundException("No se encontro Reserva con el idHora " + obj.getIdHora())));
        reservaModificada.setCanchaPrecio(canchaPrecioRepository.findById(obj.getIdCanchaPrecio()).orElseThrow(() ->
                new NotFoundException("No se encontro Reserva con el id CanchaPrecio " + obj.getIdCanchaPrecio())));

        reservaRepository.save(reservaModificada);
        ReservaDtoResponse reser = new ReservaDtoResponse(reservaModificada);
        return reser;
    }

    @Override
    public Reserva save(Reserva obj) {
        return null;
    }

    @Override
    public Reserva update(Reserva obj) {
        return null;
    }

    @Override
    public Reserva getbyId(Long id) {
        return reservaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("No se encontro razon social con el id: " + "variable"));
    }

    @Override
    public List<Reserva> getAll() {
        return (List<Reserva>) reservaRepository.findAll();
    }

    @Override
    public void delete(Reserva obj) {
       //reservaRepository. aca voy a barrer el campo boolean del horario
    }
}


/*reservaNueva.setIdReserva(oldReserva.getIdReserva());
        // Comparar año, mes y día para cambiar o no la fecha de reserva
        if (oldReserva.getFecha().getYear() != obj.getFecha().getYear() ||
                oldReserva.getFecha().getMonth() != obj.getFecha().getMonth() ||
                oldReserva.getFecha().getDay() != obj.getFecha().getDay()) {
            reservaNueva.setFecha(obj.getFecha());
        } else {
            reservaNueva.setFecha(oldReserva.getFecha());
        }
        ///Valido si cambio idHora
        if(obj.getHora().getIdHora() != oldReserva.getHora().getIdHora()){
            reservaNueva.setHora(oldReserva.getHora());
            }else {
                reservaNueva.setHora(oldReserva.getHora());
        }
        //valido si cambio el id de cancha precio
        if(obj.getCanchaPrecio().getIdCanchaPrecio() != oldReserva.getCanchaPrecio().getIdCanchaPrecio()){
            reservaNueva.setCanchaPrecio(obj.getCanchaPrecio());
        }else{
            reservaNueva.setCanchaPrecio(oldReserva.getCanchaPrecio());
        }
        //El usuario va a ser el mismo xq es el que esta modificando la reserva
        reservaNueva.setUsu(obj.getUsu());*/