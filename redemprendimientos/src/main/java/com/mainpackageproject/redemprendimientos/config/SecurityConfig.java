package com.mainpackageproject.redemprendimientos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase de configuración para la seguridad de la aplicación.
 * Proporciona configuraciones relacionadas con la codificación de contraseñas y otros aspectos de seguridad.
 */
@Configuration
public class SecurityConfig {

    /**
     * Define un bean de {@link PasswordEncoder} que utiliza el algoritmo de hashing BCrypt.
     * 
     * @return una instancia de {@link BCryptPasswordEncoder} para codificar contraseñas.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
