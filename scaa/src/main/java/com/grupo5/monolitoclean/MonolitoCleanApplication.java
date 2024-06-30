package com.grupo5.monolitoclean;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class MonolitoCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonolitoCleanApplication.class, args);
	}
}
