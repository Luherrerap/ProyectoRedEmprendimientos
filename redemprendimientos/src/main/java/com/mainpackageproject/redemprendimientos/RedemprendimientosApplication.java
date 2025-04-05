package com.mainpackageproject.redemprendimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal de la aplicación Redemprendimientos.
 * Esta clase inicializa y ejecuta la aplicación Spring Boot.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.mainpackageproject.redemprendimientos.repository",
    "com.mainpackageproject.redemprendimientos.service",
    "com.mainpackageproject.redemprendimientos.models",
    "com.mainpackageproject.redemprendimientos.controllers",
    "com.mainpackageproject.redemprendimientos.config",
})
public class RedemprendimientosApplication {

    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(RedemprendimientosApplication.class, args);
    }
}
