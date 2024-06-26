package com.unpaz.reservas.dtos.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
@Data
public class CanchasPreciosDtoReq {
    private String descripcionCancha;
    private BigDecimal valorPesos;
}
