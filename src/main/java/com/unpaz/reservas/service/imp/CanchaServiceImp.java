package com.unpaz.reservas.service.imp;

import com.unpaz.reservas.model.Canchas;
import com.unpaz.reservas.repository.CanchaRepository;
import com.unpaz.reservas.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CanchaServiceImp implements CanchaService {

    @Autowired
    private CanchaRepository cancha;

    @Override
    public Canchas save(Canchas obj) {
        return cancha.save(obj);
    }

    @Override
    public Canchas update(Canchas obj) {
        return null;
    }

    @Override
    public Canchas getbyId(Long id) {
        return cancha.findById(id).orElse(null);
    }


    @Override
    public List<Canchas> getAll() {
        return /*List.of()*/(List<Canchas>) cancha.findAll();
    }

    @Override
    public void delete(Canchas obj) {
        cancha.deleteById(obj.getIdCanchas());
    }
}
