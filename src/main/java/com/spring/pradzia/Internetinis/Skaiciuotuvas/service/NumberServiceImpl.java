package com.spring.pradzia.Internetinis.Skaiciuotuvas.service;

import com.spring.pradzia.Internetinis.Skaiciuotuvas.model.Number;
import com.spring.pradzia.Internetinis.Skaiciuotuvas.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;


//@Service - sluoksnis skirtas "verslo logikai"
//po Serviso sluoksniu kreipiames i DAO (duomenu baze)
@Service
public class NumberServiceImpl implements NumberService{

//Autowired naudojama automatinei priklausomybiu injekcijai(IOC-inversion of control)
//kad panaudoti Autowired anotacija, reikia pirmiausiai tureti apsirasiusi @Bean @Configuration klase

@Autowired
@Qualifier("NumberDAO") // si anotacija kartu su @Autowired patikslina su kuriuo konkreciai Bean susieti priklausomybe
//jeigu @Configuration klaseje yra daugiau negu 1 Bean, @Qualifier anotacija yra privaloma, kitu atveju yra metama klaida
//bean veikia pagal singleton principa

private NumberDAO numberDAO;
    @Override
    public void insert(Number number) {
    numberDAO.insertEntity(number);
    }

    @Override
    public Number getById(int id) {
        return numberDAO.findEntityById(id);
    }

    @Override
    public List<Number> getAll() {
        return numberDAO.findEntities();
    }

    @Override
    public void update(Number number) {
    numberDAO.updateEntity(number);
    }

    @Override
    public void delete(int id) {
    numberDAO.removeEntityById(id);
    }
}
