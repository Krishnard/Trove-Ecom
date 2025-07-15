package com.example.demo.Gateway;

import com.example.demo.DTO.AllProductResponseDTO;
import com.example.demo.DTO.ProductDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class OkHttpProductService {
    
    private final Dotenv dotenv = Dotenv.configure().load();
    
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String baseUrl;
    
    public OkHttpProductService(OkHttpClient okHttpClient) {
        
        String baseurl = dotenv.get("fakeStoreURL");
        this.okHttpClient = okHttpClient;
        this.baseUrl = baseurl ; // Or read from dotenv
    }
    
    public List<ProductDTO> getAllProducts() throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + "products")
                .build();
        
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Unexpected response: " + response);
            }
            
            String json = response.body().string();
            
            AllProductResponseDTO allProductResponseDTO = objectMapper.readValue(
                    json,
                    AllProductResponseDTO.class
            );
            
            return allProductResponseDTO.getProducts(); // assuming this returns List<ProductDTO>
        }
    }
    
}
