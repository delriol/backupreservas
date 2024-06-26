package com.unpaz.reservas.repository;

import com.unpaz.reservas.model.Hora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
    @Repository
    public interface HoraRepository extends JpaRepository<Hora,Long> {
        @Query(value = "SELECT h.id_hora, h.descripcion, h.disponible FROM Horas h LEFT JOIN Reservas r ON h.id_hora = r.id_hora " +
                "AND r.fecha = :date WHERE r.id_reserva IS NULL ORDER BY h.descripcion", nativeQuery = true)
        List<Hora> findAvailableHorasByFecha(@Param("date") Date fecha);
    }

