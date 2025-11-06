package com.Projeto.Tca.prisma20;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("oi marcos");
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
