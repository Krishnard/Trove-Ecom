package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class CategoryService implements ICategoryService{
    
    private ICategoryGateway categoryGateway;
    
    public CategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
    
    
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    
    }
    
}

