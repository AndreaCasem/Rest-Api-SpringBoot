package com.api.RegisterLogin.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // Generando getters y setters con Lombok
@AllArgsConstructor // Generando el constructor con todos los parametros con Lombok
@NoArgsConstructor // Generando el constructor vacio con Lombok
@ToString // Generando el metodo toString con Lombok

public class LoginDTO {
    private String email;
    private String password;
}
