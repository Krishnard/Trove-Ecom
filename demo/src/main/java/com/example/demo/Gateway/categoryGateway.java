package com.example.demo.Gateway;

import com.example.demo.Gateway.API.allCategoryAPI;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


@Component
public class categoryGateway implements ICategoryGateway{
    
    private allCategoryAPI allCategoryAPI;
    
    public categoryGateway(allCategoryAPI allCategoryAPI) {
        this.allCategoryAPI = allCategoryAPI;
    }
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
    
        CategoryResponseDTO categoryResponseDTO = this.allCategoryAPI.getAllCategories().execute().body();
        
        if (categoryResponseDTO == null ){
            throw new IOException("Failed to fetch categories from the API");
        }
        
        return categoryResponseDTO.getCategories().stream()
                .map(category -> CategoryDTO.builder().name(category).build())
                .toList();
    }
    
    
}
