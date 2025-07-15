package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllProductResponseDTO {
    
    private String status;
    private String message;
    private List<ProductDTO> products;
}
