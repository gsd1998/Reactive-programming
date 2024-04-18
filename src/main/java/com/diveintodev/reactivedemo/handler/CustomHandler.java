package com.diveintodev.reactivedemo.handler;

import com.diveintodev.reactivedemo.dto.Product;
import com.diveintodev.reactivedemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CustomHandler {

    @Autowired
    private ProductRepo productRepo;

    public Mono<ServerResponse> viewAllProducts(ServerRequest request){
        Flux<Product> allProducts = productRepo.findAll().delayElements(Duration.ofSeconds(5));
        return ServerResponse.ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
        .body(allProducts, Product.class);
    }
    public Mono<ServerResponse> getAllProducts(ServerRequest request){
        Flux<Product> products = Flux.range(1, 2000)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Product(i, "Customer : " + i, "description for " + i));
                return ServerResponse.ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(products,Product.class);
    }
    public Mono<ServerResponse> getProduct(ServerRequest request) {
        int id  = Integer.valueOf(request.pathVariable("id"));
        Flux<Product> products = Flux.range(1, 20)
                .map(i -> new Product(i, "Customer : " + i, "description for " + i));
        Mono<Product> product = products.filter(i -> i.getId() == id).next();
        return ServerResponse.ok().body(product, Product.class);
    }
    public Mono<ServerResponse> saveProduct(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
        Mono<String> productSingle = product.map(i -> i.getId() + " : " + i.getName() + " : " + i.getDescription());
        return ServerResponse.ok().body(productSingle, String.class);
    }
}
