package com.example.webflux.service.impl;

import com.example.webflux.model.User;
import com.example.webflux.repository.UserRepository;
import com.example.webflux.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public Flux <User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public Mono <User> save(User user) {
    return userRepository.save(user);
  }

  @Override
  public Mono <User> findById(String id) {
     return userRepository.findById(id);
  }
}
