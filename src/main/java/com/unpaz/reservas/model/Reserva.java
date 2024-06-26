package com.unpaz.reservas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="RESERVAS")
public class Reserva {
    @Column(name = "ID_RESERVA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    @Column(name = "FECHA")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "ID_CANCHAS_PRECIOS", referencedColumnName = "ID_CANCHAS_PRECIOS")
    private CanchaPrecio canchaPrecio;
    @ManyToOne
    @JoinColumn(name = "ID_HORA")//, referencedColumnName = "ID_HORA")
    private Hora hora;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")//,referencedColumnName = "ID_USUARIO")
    private Usuario usu;


    /*@JoinTable(
            name = "canchas_precio",
            joinColumns = @JoinColumn(name = "FK_CANCHAS_PRECIO"),
          )*/
}
