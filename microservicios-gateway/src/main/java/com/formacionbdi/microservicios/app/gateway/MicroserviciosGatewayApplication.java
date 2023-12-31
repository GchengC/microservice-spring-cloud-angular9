package com.formacionbdi.microservicios.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosGatewayApplication.class, args);
    }

}
