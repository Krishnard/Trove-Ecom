package com.example.demo.Gateway.API;

import com.example.demo.DTO.AllProductResponseDTO;
import com.example.demo.DTO.SingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface ProductAPI {

    @GET("products/{id}")
    Call<SingleProductResponseDTO> getSingleProduct(@Path("id") int id) throws IOException;


    @GET("products")
    Call<AllProductResponseDTO> getAllProducts() throws IOException;


}
