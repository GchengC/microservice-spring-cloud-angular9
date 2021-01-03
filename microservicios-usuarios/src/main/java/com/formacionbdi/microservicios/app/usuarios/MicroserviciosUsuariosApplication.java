package com.formacionbdi.microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.formacionbdi.microservicios.commons.alumnos.models.entity"})
@EnableFeignClients
public class MicroserviciosUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
    }

}
