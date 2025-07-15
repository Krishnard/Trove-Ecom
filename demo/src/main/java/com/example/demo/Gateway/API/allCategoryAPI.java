package com.example.demo.Gateway.API;

import com.example.demo.DTO.CategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;


public interface allCategoryAPI {
    
  
    @GET("products/category")
    Call<CategoryResponseDTO> getAllCategories() throws IOException;
    
    
}
