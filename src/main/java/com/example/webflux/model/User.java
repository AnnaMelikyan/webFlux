package com.example.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {

  @Id
  private String id;
  private String name;
  private String email;
  private String lastName;
  private List<Product> products;

}
