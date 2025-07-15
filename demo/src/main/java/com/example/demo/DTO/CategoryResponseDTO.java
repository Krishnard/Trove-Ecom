package com.example.demo.DTO;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    
    private String status;
    
    private String message;
    
    private List<String> categories;
}
