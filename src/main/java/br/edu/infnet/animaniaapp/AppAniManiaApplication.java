package br.edu.infnet.animaniaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppAniManiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAniManiaApplication.class, args);
	}

}
