package com.spring.pradzia.Internetinis.Skaiciuotuvas.model;


import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
// Data Axis Object (susijes su duomenu baze)
public interface NumberDAO {

    // interfeisas yra metodu antrastes

    void insertEntity(Number number);
    Number findEntityById(int id);
    List<Number> findEntities();
    void updateEntity(Number number);
    void removeEntityById(int id);
}
