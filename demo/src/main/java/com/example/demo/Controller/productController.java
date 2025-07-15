package com.example.demo.Controller;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {

    private IProductService productService;

    public productController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public List<ProductDTO> getSingleProduct(@PathVariable Integer id) throws IOException {
        return this.productService.getSingleProduct(id);

    }

    @GetMapping("/category")
    public List<ProductDTO> getAllProducts() throws IOException {
        return this.productService.getAllProducts();
    }

}
