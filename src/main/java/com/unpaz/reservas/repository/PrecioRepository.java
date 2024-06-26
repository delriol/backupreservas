package com.unpaz.reservas.repository;

import com.unpaz.reservas.model.PrecioHora;
import org.springframework.data.repository.CrudRepository;

public interface PrecioRepository extends CrudRepository<PrecioHora,Long> {
}
