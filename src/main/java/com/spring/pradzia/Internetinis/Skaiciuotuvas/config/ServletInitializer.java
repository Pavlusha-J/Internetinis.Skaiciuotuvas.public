package com.spring.pradzia.Internetinis.Skaiciuotuvas.config;

import com.spring.pradzia.Internetinis.Skaiciuotuvas.InternetinisSkaiciuotuvasApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternetinisSkaiciuotuvasApplication.class);
	}

}
