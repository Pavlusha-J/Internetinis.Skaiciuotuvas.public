package com.spring.pradzia.Internetinis.Skaiciuotuvas.model;

import jakarta.validation.constraints.Min;

import javax.persistence.*;

//Entity tai POJO klase sujungta su DB esancia lentele naudojant ORM technika
@Entity
//si anotacija nurodo jog susiesime POJO klase su DB esancia lentele, kurios pavadinimas "numbers"
@Table(name = "numbers") // daugiskaita pagal klases pavadinima
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //atitinka DB autoincrement f-ja
    @Column(name = "id")
    private int id;

    @Column(name = "sk1")
    @Min(value=0, message="Validacijos klaida: skaicius negali buti neigiamas")
    private int sk1;

    @Column(name = "sk2")
    @Min (value=0, message="Validacijos klaida: skaicius negali buti neigiamas")
    private int sk2;

    @Column(name = "zenklas")
    private String zenklas;

    @Column(name = "rezultatas")
    private int rezultatas;

    public Number(int rezultatas, String zenklas, int sk2, int sk1, int id) {
        this.rezultatas = rezultatas;
        this.zenklas = zenklas;
        this.sk2 = sk2;
        this.sk1 = sk1;
        this.id = id;
    }

    //Butinas tuscias konstruktorius naudojant Spring framework
    public Number(){}

    public int getId() { return id; }

    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public int getRezultatas() {
        return rezultatas;
    }

    public void setRezultatas(int rezultatas) {
        this.rezultatas = rezultatas;
    }

    public int getSk2() {
        return sk2;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public String getZenklas() {
        return zenklas;
    }

    public void setZenklas(String zenklas) {
        this.zenklas = zenklas;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", zenklas='" + zenklas + '\'' +
                ", rezultatas=" + rezultatas +
                '}';
    }
}

