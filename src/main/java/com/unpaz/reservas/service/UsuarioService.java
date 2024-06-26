package com.unpaz.reservas.service;

import com.unpaz.reservas.dtos.UsuarioRegistroDto;
import com.unpaz.reservas.model.Usuario;

import java.util.List;


public interface UsuarioService {

    public Usuario getUsusario(Long id);
    public List<Usuario> getAllUsusario();
    public void saveUsu(UsuarioRegistroDto usu);
    public void deleteUsu(Long id);
    public void editUsu(Long idOriginal, String newUsername);

}
