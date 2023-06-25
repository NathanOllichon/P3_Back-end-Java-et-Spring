package com.chatop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.chatop.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ChaTopBackEnd {

	public static void main(String[] args) {
		SpringApplication.run(ChaTopBackEnd.class, args);
	}

}
