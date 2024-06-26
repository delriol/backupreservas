package com.unpaz.reservas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data
@Table(name = "PRECIOS_HORA")
public class PrecioHora {
    @Column(name = "ID_PRECIO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrecio;
    @Column(name = "VALOR_PESOS")
    private BigDecimal valorPesos;
    @Column(name = "FECHA_VIGENCIA")
    private Date fechaVigencia ;
    @Column(name = "PRECIO_ACTIVO")
    private boolean precioActivo;


}
