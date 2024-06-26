package com.unpaz.reservas.service;

import com.unpaz.reservas.model.Contacto;

import java.util.List;

public interface ContactoService {
    public Contacto getContacto(Long id);
    public List<Contacto> getAllContacto();
    public void saveContacto(Contacto contacto);
    public void deleteContacto(Long id);
    public void  editContacto(Long id, String newNombre, String newApellido,
                              String newMail, String newTelefono);
}
