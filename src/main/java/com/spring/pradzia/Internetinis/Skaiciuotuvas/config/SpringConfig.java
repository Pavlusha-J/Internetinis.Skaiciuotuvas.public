package com.spring.pradzia.Internetinis.Skaiciuotuvas.config;

import com.spring.pradzia.Internetinis.Skaiciuotuvas.model.NumberDAO;
import com.spring.pradzia.Internetinis.Skaiciuotuvas.model.NumberDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SpringConfig {

    @Configuration
    public class AppConfig {

        @Bean
        public NumberDAO numberDAO() {
            return new NumberDAOImpl(); // Replace with your actual implementation
        }
    }
}
