package com.example.webflux.controller;

import com.example.webflux.model.Product;
import com.example.webflux.service.ProductService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {


  private final ProductService productService;

  @GetMapping("/get_all")
  public ResponseEntity<Flux<Product>> findAll(){
    return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
  }

  @PostMapping("/save")
  public ResponseEntity<Void> saveUser(@ApiParam(name = "product", value = "Product")
                                         @RequestBody @Valid Product product){
    productService.save(product);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/get_by_id")
  public ResponseEntity <Mono<Product>> findById(@ApiParam(name = "productId", value = "Product ID")
                                               @RequestParam(name = "id") String id){
    Mono <Product> byId = productService.findById(id);
    if (byId != null) return ResponseEntity.status(HttpStatus.OK).body(byId);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
