package com.api.RegisterLogin.Service;

import com.api.RegisterLogin.Dto.LoginDTO;
import com.api.RegisterLogin.Dto.UsuarioDTO;
import com.api.RegisterLogin.Response.LoginResponse;

public interface UsuarioService {
    String addUsuario(UsuarioDTO usuarioDTO);

    LoginResponse loginUsuario(LoginDTO loginDTO);
}
