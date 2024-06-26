package com.unpaz.reservas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Table(name = "CANCHAS")
@Entity
@Data
public class Canchas {
    @Column(name = "ID_CANCHA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCanchas;
    @Column(name = "DESCRIPCION")
    private String descripcion;
}
