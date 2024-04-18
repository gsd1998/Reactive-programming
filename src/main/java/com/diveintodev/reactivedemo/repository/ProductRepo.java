package com.diveintodev.reactivedemo.repository;

import com.diveintodev.reactivedemo.dto.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ReactiveCrudRepository<Product,Integer> {
}
