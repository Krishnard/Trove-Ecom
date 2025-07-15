package com.example.demo.Gateway;

import com.example.demo.DTO.ProductDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;



@Component
public interface IProductGateway {

    List<ProductDTO> getSingleProduct(int id) throws IOException;

    List<ProductDTO> getAllProducts() throws IOException;


}
