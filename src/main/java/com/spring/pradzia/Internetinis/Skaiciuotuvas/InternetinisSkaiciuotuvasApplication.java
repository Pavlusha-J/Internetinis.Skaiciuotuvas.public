package com.spring.pradzia.Internetinis.Skaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplicatios anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
//Si anotacija nurodoma klaseje turincioje pagrindini main metoda.
@SpringBootApplication

public class InternetinisSkaiciuotuvasApplication {

	public static void main(String[] args) {
		//Programos kontrole deleguojama statiniam klases metodui run
		//nurodant aplikacijos sakniniu komponenta (root).
		//Spring karkasas paleis aplikacija - tai yra startuos TomCat serveri.

		SpringApplication.run(InternetinisSkaiciuotuvasApplication.class, args);
	}

}
