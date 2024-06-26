package com.unpaz.reservas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Table(name="CONTACTOS")
@Entity
@Data
public class Contacto {
    @Column(name="ID_CONTACTO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="MAIL")
    private String mail;
    @Column(name="NTELEFONO")
    private String ntelefono;
}
