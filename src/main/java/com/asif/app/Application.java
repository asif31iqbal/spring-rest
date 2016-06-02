package com.asif.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@SpringBootApplication(scanBasePackages="com.asif")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }   
    
//    @Bean
//    public MappingJackson2HttpMessageConverter jsonConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(String.class, new StringSerializer());
//        ObjectMapper mapper = new ObjectMapper()
//            .registerModule(simpleModule);
//        converter.setObjectMapper(mapper);
//        return converter;
//    }

//    @Bean
//    public Jaxb2RootElementHttpMessageConverter jaxbConverter() {
//        return new Jaxb2RootElementHttpMessageConverter();
//    }
}