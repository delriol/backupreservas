package com.unpaz.reservas.service.imp;

import com.unpaz.reservas.dtos.request.CanchasPreciosDtoReq;
import com.unpaz.reservas.exeptions.NotFoundException;
import com.unpaz.reservas.generic.CrudGeneric;
import com.unpaz.reservas.model.CanchaPrecio;
import com.unpaz.reservas.model.Canchas;
import com.unpaz.reservas.model.Hora;
import com.unpaz.reservas.model.PrecioHora;
import com.unpaz.reservas.repository.CanchaPrecioRepository;
import com.unpaz.reservas.repository.CanchaRepository;
import com.unpaz.reservas.repository.HoraRepository;
import com.unpaz.reservas.repository.PrecioRepository;
import com.unpaz.reservas.service.CanchaPrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CanchaPrecioServiceImp implements CanchaPrecioService {
    @Autowired
    private CanchaPrecioRepository canchaPrecioRepository;
    @Autowired
    private CanchaRepository canchaRepository;
    @Autowired
    private HoraRepository horaRepository;
    @Autowired
    private PrecioRepository precioRepository;

    @Override
    public CanchaPrecio save(CanchaPrecio obj) {
        return null;
    }

    @Override
    public CanchaPrecio update(CanchaPrecio obj) {
        return null;
    }

    @Override
    public CanchaPrecio getbyId(Long id) {
        return canchaPrecioRepository.findById(id).orElseThrow(() ->
                new NotFoundException("No se encontro Cancha Precio con el id: " + id));
    }

    @Override
    public List<CanchaPrecio> getAll() {
        return (List<CanchaPrecio>) canchaPrecioRepository.findAll();
    }

    @Override
    public void delete(CanchaPrecio obj) {


    }

    @Override
    public CanchaPrecio guardarCanchaPrecio(CanchasPreciosDtoReq cpDto) {
        CanchaPrecio cpNew = new CanchaPrecio();
        Canchas cancha = new Canchas();
        PrecioHora precio = new PrecioHora();
        precio.setValorPesos(cpDto.getValorPesos());
        precio.setFechaVigencia(new Date());
        precio.setPrecioActivo(true);
        cancha.setDescripcion(cpDto.getDescripcionCancha());

        cpNew.setCanchas(canchaRepository.save(cancha));
        cpNew.setPrecioHora(precioRepository.save(precio));

        return canchaPrecioRepository.save(cpNew);
    }
}
