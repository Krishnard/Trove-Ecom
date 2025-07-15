package com.example.demo.Configurations;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class OkHttpAPIService {
    
    
    private final Dotenv dotenv = Dotenv.configure().load();
    
    
    @Bean
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient();
    }
    
    
}
