package com.unpaz.reservas.repository;

import com.unpaz.reservas.model.CanchaPrecio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaPrecioRepository extends CrudRepository<CanchaPrecio,Long> {
}
