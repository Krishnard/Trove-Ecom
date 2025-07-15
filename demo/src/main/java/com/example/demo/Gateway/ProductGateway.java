package com.example.demo.Gateway;

import com.example.demo.DTO.AllProductResponseDTO;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.SingleProductResponseDTO;
import com.example.demo.Gateway.API.ProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ProductGateway implements IProductGateway{


    private ProductAPI productAPI;

    public ProductGateway(ProductAPI productAPI) {
        this.productAPI = productAPI;
    }

    @Override
    public List<ProductDTO> getSingleProduct(int id) throws IOException {
        SingleProductResponseDTO SingleProductResponseDTO = this.productAPI.getSingleProduct(id).execute().body();

        if (SingleProductResponseDTO == null) {
            throw new IOException("Failed to fetch product with ID: " + id);
        }

        ProductDTO product = SingleProductResponseDTO.getProduct();
    
        return Stream.of(product)
                .map(p -> ProductDTO.builder()
                        .id(p.getId())
                        .title(p.getTitle())
                        .price(p.getPrice())
                        .brand(p.getBrand())
                        .model(p.getModel())
                        .color(p.getColor())
                        .category(p.getCategory())
                        .discount(p.getDiscount())
                        .image(p.getImage())
                        .description(p.getDescription())
                        .onSale(p.getOnSale())
                        .popular(p.getPopular())
                        .build()
                )
                .collect(Collectors.toList());
    
    
    
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        AllProductResponseDTO allProductResponseDTO = this.productAPI.getAllProducts().execute().body();

        if (allProductResponseDTO == null) {
            throw new IOException("Failed to fetch all products.");
        }

        return allProductResponseDTO.getProducts().stream()
                .map(p -> ProductDTO.builder()
                        .id(p.getId())
                        .title(p.getTitle())
                        .price(p.getPrice())
                        .brand(p.getBrand())
                        .model(p.getModel())
                        .color(p.getColor())
                        .category(p.getCategory())
                        .discount(p.getDiscount())
                        .image(p.getImage())
                        .description(p.getDescription())
                        .onSale(p.getOnSale())
                        .popular(p.getPopular())
                        .build())
                .toList();
    }
}
