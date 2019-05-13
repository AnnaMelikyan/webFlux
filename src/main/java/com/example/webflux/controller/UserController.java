package com.example.webflux.controller;

import com.example.webflux.model.User;
import com.example.webflux.service.UserService;
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
@RequestMapping("/user")
public class UserController {


  private final UserService userService;

  @GetMapping("/get_all")
  public ResponseEntity<Flux<User>> findAll(){
    return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
  }

  @PostMapping("/save")
  public ResponseEntity<Mono<User>> saveUser(@ApiParam(name = "user", value = "User")
                                         @RequestBody @Valid User user){

    return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
  }

  @GetMapping("/get_by_id")
  public ResponseEntity <Mono<User>> findById(@ApiParam(name = "userId", value = "User ID")
                                               @RequestParam(name = "id") String id){
    Mono <User> byId = userService.findById(id);
    if (byId != null) return ResponseEntity.status(HttpStatus.OK).body(byId);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
