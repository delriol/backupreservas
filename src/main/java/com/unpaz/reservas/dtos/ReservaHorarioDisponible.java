package com.unpaz.reservas.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class ReservaHorarioDisponible {
    private Date fecha;
    private Long idCancha;
}
