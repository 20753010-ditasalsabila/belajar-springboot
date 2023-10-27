package com.enigma.belajar_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class BelajarSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringBootApplication.class, args);
	}
}
