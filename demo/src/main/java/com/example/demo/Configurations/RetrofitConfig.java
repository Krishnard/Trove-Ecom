package com.example.demo.Configurations;

import com.example.demo.Gateway.API.ProductAPI;
import com.example.demo.Gateway.API.allCategoryAPI;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Configuration
public class RetrofitConfig {
    
    private final Dotenv dotenv = Dotenv.configure().load();
    
    // This file handles the configuration of Retrofit, a type-safe HTTP client for Android and Java.
    // Do modifications as per given in documentation.
    
    @Bean
    public Retrofit retrofit() {
        String baseURL = dotenv.get("fakeStoreURL");
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)// Base URL for the API
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        return retrofit;
    }
    
    @Bean
    public allCategoryAPI allCategoryAPI(Retrofit retrofit) {
        // This method creates an instance of the allCategoryAPI interface using the Retrofit instance.
        return retrofit.create(allCategoryAPI.class);
    }
    
    @Bean
    public ProductAPI productAPI(Retrofit retrofit) {
        // This method creates an instance of the ProductAPI interface using the Retrofit instance.
        return retrofit.create(ProductAPI.class);
    }
    
    
}
