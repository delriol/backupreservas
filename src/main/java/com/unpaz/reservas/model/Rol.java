package com.unpaz.reservas.model;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "ROLES")
@Data
@Entity
public class Rol {
    @Column(name="ID_ROL")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Column(name="DESCRIPCION")
    private String descripcion;
}
