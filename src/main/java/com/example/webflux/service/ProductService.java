package com.example.webflux.service;

import com.example.webflux.model.Product;
import com.example.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  Flux <Product> getAll();

  Mono <Product> save(Product product);

  Mono <Product> findById(String id);

}
