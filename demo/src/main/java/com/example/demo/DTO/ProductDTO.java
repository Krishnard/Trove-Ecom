package com.example.demo.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    
    private int id;
    private String title;
    private String image;
    private double price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String category;
    private Integer discount;
    private Boolean onSale;
    private Boolean popular;
    
}
