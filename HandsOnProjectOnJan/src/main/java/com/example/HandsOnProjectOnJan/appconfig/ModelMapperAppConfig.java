package com.example.HandsOnProjectOnJan.appconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperAppConfig {

    @Bean
    public ModelMapper getModelMapper ( ) {
        return  new ModelMapper ();
    }
}
