package com.example.webflux.service.impl;

import com.example.webflux.model.Product;
import com.example.webflux.repository.ProductRepository;
import com.example.webflux.repository.ProductRepository;
import com.example.webflux.service.ProductService;
import com.example.webflux.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository ProductRepository;


  @Override
  public Flux <Product> getAll() {
    return ProductRepository.findAll();
  }

  @Override
  public Mono <Product> save(Product Product) {
    return ProductRepository.save(Product);
  }

  @Override
  public Mono <Product> findById(String id) {
     return ProductRepository.findById(id);
  }
}
