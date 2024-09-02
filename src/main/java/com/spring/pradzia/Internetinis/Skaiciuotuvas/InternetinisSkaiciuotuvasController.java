package com.spring.pradzia.Internetinis.Skaiciuotuvas;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//WEB kontroleris leidzia viduje naudoti @RequestMapping
//@RestController anotacija nurodo, jog pvz. String tipo rezultatas turetu buti ispaudziamas kientui toks koks yra


@RestController
//Zymi konfiguracijos komponeneta. Viduje leidzia kurti Bean per metodus su@Bean anotacija
//Si klases lygio anotacija nurodo Spring karkasui "Atspeti" konfiguracija.
//Remiantis priklausomybemis (Jar bibliotekomis), kurias programuotojas itraukia i projekta (pom.xml)
// Siuo atveju ji veikia kartu su main metodu.

@EnableAutoConfiguration


public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/")

    public String Index() {

        //  ApplicationContext yra interfeisas skirtas suteikti informacija apie aplikacijos konfiguracija.
        // Siuo atveju naudojama konfiguracija paimama is beans.xml failo
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //bean - klases objektas kuris atitinka singleton sablona.
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
return bean.getHello();

//        return"Internetinis skaiciuotuvas <p>" +
//                "Galimos operacijos: <br>" +
//                "&nbsp;&nbsp; sudeti <br>" +
//                "&nbsp;&nbsp; atimti <br>" +
//                "&nbsp;&nbsp; sudauginti <br>" +
//                "&nbsp;&nbsp; padalinti <br></p>";

    }
}



