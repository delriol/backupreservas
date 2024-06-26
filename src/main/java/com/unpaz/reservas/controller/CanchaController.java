package com.unpaz.reservas.controller;

import com.unpaz.reservas.dtos.request.CanchasPreciosDtoReq;
import com.unpaz.reservas.exeptions.NotFoundException;
import com.unpaz.reservas.generic.GenericResponseController;
import com.unpaz.reservas.model.Canchas;
import com.unpaz.reservas.service.CanchaPrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/canchas-precios")
@RestController
public class CanchaController implements GenericResponseController {

    @Autowired
    private CanchaPrecioService canchaPrecioService;

    @GetMapping("/getall")
    public ResponseEntity<?> listarCanchasPrecios() {
        clearResponse();
        response.put("Data : ", canchaPrecioService.getAll());
        return getResponse(HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> listarUnaCanchaPrecio(@PathVariable Long id) throws NotFoundException {
        clearResponse();
        response.put("Data : ", canchaPrecioService.getbyId(id));
        return getResponse(HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createCanchasPrecio(@RequestBody CanchasPreciosDtoReq cpDto) throws NotFoundException {
        clearResponse();
        response.put("Cancha y Precio craedos con exito : ", canchaPrecioService.guardarCanchaPrecio(cpDto));
        return getResponse(HttpStatus.CREATED);
    }
}

/*
* La idea aca es registrar horarios con precio y fecha de vigencia.
* 1- para crear enviar descripcionCancha , valor
* 2-
* */