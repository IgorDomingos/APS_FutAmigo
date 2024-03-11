package br.ufpe.cin.futebolamigouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FutebolamigoUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutebolamigoUserApplication.class, args);
	}

}
