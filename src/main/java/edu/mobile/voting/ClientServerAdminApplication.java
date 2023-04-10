package edu.mobile.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "edu.mobile")
public class ClientServerAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServerAdminApplication.class, args);
	}

}