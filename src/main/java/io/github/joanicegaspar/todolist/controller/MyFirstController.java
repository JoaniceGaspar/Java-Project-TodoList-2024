package io.github.joanicegaspar.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstRoot") // Primeira Rota
// http://loalhost:8080/firstRoot
public class MyFirstController {

  /*
   * Methods for making HTTP requisitions:
   * GET - to get data
   * POST - to add data
   * PUT - to update data
   * DELETE - to remove data
   * PATCH - to change only part of data
   */
  
  // Class Method
  @GetMapping("/")
  public String firstMessage() {
    return "It worked";
  }

  public String toString() {
    return "MyFirstController []";
  }
}
