package com.likelion.likelionshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LikeLionShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikeLionShopApplication.class, args);
	}

}
