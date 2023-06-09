package com.api.RegisterLogin.Repository;


import com.api.RegisterLogin.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findOneByEmailAndPassword(String email, String password);
    Usuario findByEmail(String email);
}
