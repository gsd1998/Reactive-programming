package com.diveintodev.reactivedemo.service;

import com.diveintodev.reactivedemo.dto.Product;
import com.diveintodev.reactivedemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Mono<Product> addProduct(Product product) {
        return repo.save(product);
    }

    public Flux<Product> viewProducts() {
        return repo.findAll();
    }
}
