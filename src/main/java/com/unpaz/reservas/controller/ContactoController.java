package com.unpaz.reservas.controller;

import com.unpaz.reservas.model.Contacto;
import com.unpaz.reservas.service.ContactoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/contacto")
@RestController
public class ContactoController {
    private final ContactoService cont;

    public ContactoController(ContactoService cont) {
        this.cont = cont;
    }

    @GetMapping("/getall")
    public List<Contacto> getAllContactos(){
        return cont.getAllContacto();
    }

    @GetMapping("/getcontacto/{id}")
    public Contacto getContacto(@PathVariable Long id){
        return cont.getContacto(id);
    }

    @PostMapping("/guardar")
    public String saveContacto(@RequestBody Contacto contacto){
        cont.saveContacto(contacto);
        return "Contacto creado con exito";
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteContacto(@PathVariable Long id){
        cont.deleteContacto(id);
        return "Se Elimino el Contacto con exito";
    }
}
