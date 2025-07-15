package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    List<ProductDTO> getSingleProduct(int id) throws IOException;

    List<ProductDTO> getAllProducts() throws IOException;
}
