package com.diveintodev.reactivedemo.controller;


import com.diveintodev.reactivedemo.dto.Product;
import com.diveintodev.reactivedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    public Mono<Product> addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public Flux<Product> viewProducts(){
        return productService.viewProducts();
    }

}
