package com.example.webflux.service;

import com.example.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Flux <User> getAll();

  Mono <User> save(User user);

  Mono <User> findById(String id);

}
