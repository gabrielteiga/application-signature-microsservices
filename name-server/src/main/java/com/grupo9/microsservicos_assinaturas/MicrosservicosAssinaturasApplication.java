package com.grupo9.microsservicos_assinaturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicrosservicosAssinaturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosservicosAssinaturasApplication.class, args);
	}

}
