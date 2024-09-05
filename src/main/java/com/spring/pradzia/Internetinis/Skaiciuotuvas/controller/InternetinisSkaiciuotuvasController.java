package com.spring.pradzia.Internetinis.Skaiciuotuvas.controller;


import com.spring.pradzia.Internetinis.Skaiciuotuvas.model.Number;
import com.spring.pradzia.Internetinis.Skaiciuotuvas.service.NumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//WEB kontroleris leidzia viduje naudoti @RequestMapping
//@RestController anotacija nurodo, jog pvz. String tipo rezultatas turetu buti ispaudziamas kientui toks koks yra


//@Restcontroller anotacija naudojama tada kai frontende nenaudojam springoJavaScript, React, Angular)
//Dazniausiai grazinami formatai json, xml
//Tai yra negraziname vaizdo(formos HTML JSP
// kadangi mums reikia grazinti vaizda(view) pagal Spring mvc, naudosime anotacija @Controller

@Controller
//Zymi konfiguracijos komponeneta. Viduje leidzia kurti Bean per metodus su@Bean anotacija
//Si klases lygio anotacija nurodo Spring karkasui "Atspeti" konfiguracija.
//Remiantis priklausomybemis (Jar bibliotekomis), kurias programuotojas itraukia i projekta (pom.xml)
// Siuo atveju ji veikia kartu su main metodu.

@EnableAutoConfiguration
public class InternetinisSkaiciuotuvasController {

    //Kadangi skaiciuotuvo forma naudoja POST metoda, cia irgi nurodysim POST

    //arba sitaip galima :   @PostMapping("/skaiciuoti")
    //RequestParam anotacija perduoda siuo atveju per url perduotus duomenis (du ivedimoSarasa operacijos zenklas)
    // kurie patalpinasi i sarasa (raktas reiksme)
    // 1 stringas yra raktas (sk1,sk2 zenklas), 2 stringas yra reiksme.
    // Raktai tiek frontende, tiek backende turi sutapti!!!
    //URL pavyzdys: http://127.0.0.1:8080/skaiciuoti?sk1=2&sk2=3&zenklas=*
private final NumberService numberService;
    @Autowired
    public InternetinisSkaiciuotuvasController(NumberService numberService){
    this.numberService=numberService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    public String Skaiciuoti(
            //SVARBU: parametras BindingResult turi eiti iskarto po anotacijos @Valid
            //Kitu atveju gausite klaida "Validation faild for object"
            @Valid @ModelAttribute("number")
            Number numb,
            BindingResult bindingResult,
            @RequestParam HashMap <String, String> ivedimoSarasa, ModelMap isvedimoSarasas) {
// jeigu validacijos klaidos (zr.Number class aprasyta validacija prie kiekvieno skaiciaus)

        if (bindingResult.hasErrors()) {
            //Vartotojas lieka skaiciuotuvo puslapyje tol, kol neistaiso validacijos klaidu
            return "skaiciuotuvas";

        } else {
            int sk1 = Integer.parseInt(ivedimoSarasa.get("sk1"));
            int sk2 = Integer.parseInt(ivedimoSarasa.get("sk2"));
            String zenklas = ivedimoSarasa.get("zenklas");
            double rezultatas = 0;

            if (zenklas.equals("+")) {
                rezultatas = sk1 + sk2;
            } else if (zenklas.equals("-")) {
                rezultatas = sk1 - sk2;
            } else if (zenklas.equals("*")) {
                rezultatas = sk1 * sk2;
            } else if (zenklas.equals("/")) {
                rezultatas = sk1 / sk2;
            }
            isvedimoSarasas.put("sk1", sk1);
            isvedimoSarasas.put("sk2", sk2);
            isvedimoSarasas.put("zenklas", zenklas);
            isvedimoSarasas.put("rezultatas", rezultatas);

            //Vartotojas praejo validacija - skaiciuojamas rezultatas
            return "skaiciuoti";
        }
    }        //Per url perduodamas raktas (kintamasis) turi pavadinima sk1
        //Pagal rakta sk1 istraukiama reiksme pvz (tarkime vartotojas ivede 8)
        //Vadinasi mums reikia konvertuoti is String i Int kad paskaiciuotume rezultata




        //Ivedimo sarasas naudojamas siusti duomenis is Spring MVC controllerio i Jsp faila (vaizda)

        //Grazinamas vaizdas(forma)
        //Svarbu nurodyti per Aplication.properties prefix ir suffix
        //Nes pagal tai ieskos vaizdo projekte

       // return "skaiciuoti";

        //return sk1 + " " + zenklas + " " + sk2 + " " + " = " + rezultatas;

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

    @RequestMapping(method = RequestMethod.GET, value =  "/")
    //arba galima parasyti @GetMapping("/")
    public String rodytiPagrindiniPuslapi(Model model){
        //jeigu Model"number" nepraeina validacijos - per ji grazinamos validacijos klaidos i View
        model.addAttribute("number", new Number());
        //Graziname jsp faila, kuris turi buti talpinamas aplanke: "webapp--> WEB-INF -->JSP"
        return "skaiciuotuvas";
    }

    @GetMapping("/numbers")
    public String getAllNumbers( Model model){
    model.addAttribute("numbers", numberService.getAll());
        return "numbers";
    }

    //id gaunamas is front endo vartotojui pasirinkus konkretu irasa
    @GetMapping("/show(id)")
    public String getById(@RequestParam("id")int id, Model model){
        model.addAttribute("number", numberService.getById(id));
        return "number";
    }

    @GetMapping("/delete(id)")
    public String deleteById(@RequestParam("id")int id, Model model){
        numberService.delete(id);
        model.addAttribute("number", numberService.getAll());
        return "numbers";
    }

    //atnaujinant irasa pirmiausiai reikia ji parodyti i atskira forma
    @GetMapping("/update(id)")
    public String updateById(@RequestParam("id")int id, Model model){
        //kai uzkrauname iraso redagavimo forma, privalome jos laukelius uzpildyti iraso informacija
        model.addAttribute("number", numberService.getById(id));
        return "update";
    }


    //kadangi forma naudoja metoda POST, cia irgi naudojame Post
    @PostMapping("/updateNumber")
    public String updateNumber(@ModelAttribute("number")Number number) {
        numberService.update(number);
        //redirekt nukreipia vartotoja i irasa atvaizdavimo puslapi (getbyId)
        return "redirect:/show?id=" + number.getId();
    }
}



