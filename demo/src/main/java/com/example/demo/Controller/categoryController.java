package com.example.demo.Controller;
import com.example.demo.DTO.CategoryDTO;
import com.example.demo.Service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class categoryController {
    
    private ICategoryService categoryService;
    
    public categoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryService.getAllCategories();
    }
    
    
}

