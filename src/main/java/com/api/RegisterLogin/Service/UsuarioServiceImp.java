package com.api.RegisterLogin.Service;

import com.api.RegisterLogin.Dto.UsuarioDTO;
import com.api.RegisterLogin.Entity.Usuario;
import com.api.RegisterLogin.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Inyectando una instancia de la clase UsuarioRepository

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(
                usuarioDTO.getId(),
                usuarioDTO.getNombre(),
                usuarioDTO.getEmail(),

                // Encriptación de la contraseña
                this.passwordEncoder.encode(usuarioDTO.getPassword())
        );

        // Guarda el objeto usuario en la base de datos
        usuarioRepository.save(usuario);

        return usuario.getNombre();
    }
}
