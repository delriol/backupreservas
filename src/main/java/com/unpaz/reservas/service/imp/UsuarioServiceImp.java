package com.unpaz.reservas.service.imp;

import com.unpaz.reservas.dtos.ContactoDto;
import com.unpaz.reservas.dtos.UsuarioRegistroDto;
import com.unpaz.reservas.model.Contacto;
import com.unpaz.reservas.model.Usuario;
import com.unpaz.reservas.repository.ContactoRepository;
import com.unpaz.reservas.repository.UsuarioRepository;
import com.unpaz.reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImp implements UsuarioService {
    @Autowired
    private UsuarioRepository usuRepo;
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public Usuario getUsusario(Long id) {
        return usuRepo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsusario() {
        return (List<Usuario>) usuRepo.findAll();
    }

    @Override
    public void saveUsu(UsuarioRegistroDto usuRegDto) {
        Contacto contactoNuevo = new Contacto();
        ContactoDto conDto = new ContactoDto();
        cargarContacto(usuRegDto,contactoNuevo);
        Usuario usuNuevo = new Usuario();
        Contacto conCreado = new Contacto();
        conCreado = contactoRepository.save(contactoNuevo);
        cargarUsuario(usuNuevo,usuRegDto,conCreado);
        //usuNuevo.setUsername(usuRegDto.getUserName());
        //usuNuevo.setIdPassword(usuRegDto.getPassword());

        usuRepo.save(usuNuevo);

    }

    public void cargarContacto(UsuarioRegistroDto us , Contacto con){
        con.setNombre(us.getNombre());
        con.setApellido(us.getApellido());
        con.setMail(us.getMail());
        con.setNtelefono(us.getNumeroTelefono());
    }

    public void cargarUsuario(Usuario usu, UsuarioRegistroDto usuRegDto , Contacto con){
        usu.setUsername(usuRegDto.getUserName());
        usu.setContacto(con);
        usu.setIdPassword(usuRegDto.getPassword());
    }



    @Override
    public void deleteUsu(Long id) {
        usuRepo.deleteById(id);
    }

    @Override
    public void editUsu(Long idOriginal, String newUsername) {
        Usuario us = usuRepo.findById(idOriginal).orElse(null);
        us.setUsername(newUsername);
        usuRepo.save(us);
    }
}
