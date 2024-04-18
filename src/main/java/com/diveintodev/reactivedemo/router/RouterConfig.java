package com.diveintodev.reactivedemo.router;

import com.diveintodev.reactivedemo.handler.CustomHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class RouterConfig{

    @Autowired
    private CustomHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/route/view-all",handler::viewAllProducts)
                .GET("/route/get-products",handler::getAllProducts)
                .GET("/route/get-product/{id}" ,handler::getProduct)
                .POST("/route/save-product",handler::saveProduct)
                .build();
    }
}
