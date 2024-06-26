package com.unpaz.reservas.service.imp;


import com.unpaz.reservas.model.Contacto;
import com.unpaz.reservas.repository.ContactoRepository;
import com.unpaz.reservas.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImp implements ContactoService {

    @Autowired
    private ContactoRepository contRepo;
    @Override
    public Contacto getContacto(Long id) {
        return contRepo.findById(id).orElse(null);
    }

    @Override
    public List<Contacto> getAllContacto() {
        return (List<Contacto>) contRepo.findAll();
    }

    @Override
    public void saveContacto(Contacto contacto) {
        contRepo.save(contacto);
    }

    @Override
    public void deleteContacto(Long id) {
        contRepo.deleteById(id);
    }

    @Override
    public void editContacto(Long id,String newNombre, String newApellido, String newMail, String newNtelefono) {
        Contacto con = contRepo.findById(id).orElse(null);
        con.setNombre(newNombre);
        con.setApellido(newApellido);
        con.setMail(newMail);
        con.setNtelefono(newNtelefono);    }
}
