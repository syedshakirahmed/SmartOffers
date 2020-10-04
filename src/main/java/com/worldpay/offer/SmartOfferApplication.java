package com.worldpay.offer;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.*;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableScheduling
public class SmartOfferApplication {

	public static void main(String[] args) {

		//Application.run(SmartOfferApplication.class, args);
		ApplicationContext applicationContext = run(SmartOfferApplication.class, args);

		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
