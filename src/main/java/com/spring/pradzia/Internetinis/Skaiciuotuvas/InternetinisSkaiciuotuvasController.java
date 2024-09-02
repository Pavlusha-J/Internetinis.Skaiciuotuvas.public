package com.spring.pradzia.Internetinis.Skaiciuotuvas;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//WEB kontroleris leidzia viduje naudoti @RequestMapping
//@RestController anotacija nurodo, jog pvz. String tipo rezultatas turetu buti ispaudziamas kientui toks koks yra


@RestController
//Zymi konfiguracijos komponeneta. Viduje leidzia kurti Bean per metodus su@Bean anotacija
//Si klases lygio anotacija nurodo Spring karkasui "Atspeti" konfiguracija.
//Remiantis priklausomybemis (Jar bibliotekomis), kurias programuotojas itraukia i projekta (pom.xml)
// Siuo atveju ji veikia kartu su main metodu.

@EnableAutoConfiguration


public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")

//RequestParam anotacija perduoda siuo atveju per url perduotus duomenis (du skaiciai operacijos zenklas)
    // kurie patalpinasi i sarasa (raktas reiksme)
    // 1 stringas yra raktas (sk1,sk2 zenklas), 2 stringas yra reiksme.
    // Raktai tiek frontende, tiek backende turi sutapti!!!
    //URL pavyzdys: http://127.0.0.1:8080/skaiciuoti?sk1=2&sk2=3&zenklas=*

    public String Skaiciuoti(@RequestParam HashMap <String, String> skaiciai) {

        //Per url perduodamas raktas (kintamasis) turi pavadinima sk1
        //Pagal rakta sk1 istraukiama reiksme pvz (tarkime vartotojas ivede 8)
        //Vadinasi mums reikia konvertuoti is String i Int kad paskaiciuotume rezultata

        int sk1 =Integer.parseInt(skaiciai.get("sk1"));
        int sk2 =Integer.parseInt(skaiciai.get("sk2"));
        int rezultatas =0;
        String zenklas = skaiciai.get("zenklas");

        if (zenklas.equals("+")) {
            rezultatas = sk1 + sk2;
        }else if (zenklas.equals("-")) {
            rezultatas = sk1 - sk2;
        }else if (zenklas.equals("*")) {
            rezultatas = sk1 * sk2;
        }else if (zenklas.equals("/")){
            rezultatas = sk1 / sk2;
       }

        //N.D. Suskaiciuoti ir atspausdinti rezultata
        return sk1 + " " + zenklas + " " + sk2 + " " + " = " + rezultatas;

        //  ApplicationContext yra interfeisas skirtas suteikti informacija apie aplikacijos konfiguracija.
        // Siuo atveju naudojama konfiguracija paimama is beans.xml failo
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //bean - klases objektas kuris atitinka singleton sablona.
        //HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
            //return bean.getHello();

//        return"Internetinis skaiciuotuvas <p>" +
//                "Galimos operacijos: <br>" +
//                "&nbsp;&nbsp; sudeti <br>" +
//                "&nbsp;&nbsp; atimti <br>" +
//                "&nbsp;&nbsp; sudauginti <br>" +
//                "&nbsp;&nbsp; padalinti <br></p>";

    }
}



