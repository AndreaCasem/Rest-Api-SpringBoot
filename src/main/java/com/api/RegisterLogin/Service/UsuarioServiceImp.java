package com.api.RegisterLogin.Service;

import com.api.RegisterLogin.Dto.LoginDTO;
import com.api.RegisterLogin.Dto.UsuarioDTO;
import com.api.RegisterLogin.Entity.Usuario;
import com.api.RegisterLogin.Repository.UsuarioRepository;
import com.api.RegisterLogin.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Inyectando una instancia de la clase UsuarioRepository

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registro de usuario
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

    // Validación de usuario
    @Override
    public LoginResponse loginUsuario(LoginDTO loginDTO) {
        String mensaje = " ";
        Usuario usuario1 = usuarioRepository.findByEmail(loginDTO.getEmail());
        if (usuario1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = usuario1.getPassword();
            Boolean isPasswordOk = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordOk) {
                Optional<Usuario> usuario = usuarioRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);

                if (usuario.isPresent()) {
                    return new LoginResponse("Inicio de sesión exitoso", true);
                } else {
                    return new LoginResponse("Error de inicio de sesión", false);
                }
            } else {
                return new LoginResponse("La contraseña no coincide", false);
            }
        } else {
            return new LoginResponse("El correo no existe", false);
        }
    }
}
