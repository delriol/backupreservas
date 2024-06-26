package com.unpaz.reservas.dtos.response;

import com.unpaz.reservas.model.Reserva;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class HoraResponseDto {
    private Long idHora;
    private String descripcion;
    private Boolean disponible;
}
