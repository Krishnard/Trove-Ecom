package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleProductResponseDTO {
    
    private String status;
    private String message;
    private ProductDTO product;
}
