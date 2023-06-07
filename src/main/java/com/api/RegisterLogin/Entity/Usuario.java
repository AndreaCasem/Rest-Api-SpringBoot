package com.api.RegisterLogin.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generando getters y setters con Lombok
@AllArgsConstructor // Generando el constructor con todos los parametros con Lombok
@NoArgsConstructor // Generando el constructor vacio con Lombok

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 45)
    private int id;

    @Column(length = 255)
    private String nombre;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String password;
}
