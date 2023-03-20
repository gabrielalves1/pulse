package br.org.sesisc.sim.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
