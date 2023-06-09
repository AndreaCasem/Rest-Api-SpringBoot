package com.api.RegisterLogin.UsuarioController;

import com.api.RegisterLogin.Dto.LoginDTO;
import com.api.RegisterLogin.Response.LoginResponse;
import com.api.RegisterLogin.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.RegisterLogin.Dto.UsuarioDTO;


@RestController
@CrossOrigin
@RequestMapping("/user")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Inyectando una instancia de la clase UsuarioService en el campo usuarioService de esta clase

    /* Se recibe una solicitud POST en la ruta "/save" y se espera en el
    cuerpo de la solicitud el objeto UsuarioDTO */
    @PostMapping(path = "/save")
    public String saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        String id = usuarioService.addUsuario(usuarioDTO);
        return id;
    }

    // Inicio de sesion
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = usuarioService.loginUsuario(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
