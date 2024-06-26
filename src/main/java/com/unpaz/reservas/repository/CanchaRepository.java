package com.unpaz.reservas.repository;

import com.unpaz.reservas.generic.CrudGeneric;
import com.unpaz.reservas.model.Canchas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepository extends CrudRepository<Canchas,Long> {

}
