package com.unpaz.reservas.service;

import com.unpaz.reservas.dtos.request.CanchasPreciosDtoReq;
import com.unpaz.reservas.generic.CrudGeneric;
import com.unpaz.reservas.model.CanchaPrecio;
import org.springframework.stereotype.Service;


public interface CanchaPrecioService extends CrudGeneric<CanchaPrecio, Long> {
    CanchaPrecio guardarCanchaPrecio (CanchasPreciosDtoReq cp);
}
