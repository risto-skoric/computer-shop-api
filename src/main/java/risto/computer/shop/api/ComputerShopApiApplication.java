package risto.computer.shop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// @EnableConfigurationProperties
public class ComputerShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerShopApiApplication.class, args);
	}

}
