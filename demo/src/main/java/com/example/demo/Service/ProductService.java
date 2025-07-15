package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService{

    private final IProductGateway productGateway;

    public ProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductDTO> getSingleProduct(int id) throws IOException {
        return this.productGateway.getSingleProduct(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }


}
