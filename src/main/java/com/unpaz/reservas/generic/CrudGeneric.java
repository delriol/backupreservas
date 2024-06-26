package com.unpaz.reservas.generic;

import java.util.List;

public interface CrudGeneric <T, C>{
     T save(T obj);
     T update(T obj);
     T getbyId(Long id);
     List<T> getAll();
     void delete(T obj);
}
