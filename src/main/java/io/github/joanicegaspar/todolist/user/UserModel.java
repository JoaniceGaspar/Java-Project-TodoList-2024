package io.github.joanicegaspar.todolist.user;

// A classe para criarmos um Objeto que será o Modelo de Usuário que nós pretendemos ter, daí o nome "UserModel".

// Este usuário terá: username, name e um password
public class UserModel {
  
  private String username;
  private String name;
  private String password;

  //Getters (to get ou receive data) and 
  //Setters (to set or modify data)

  // Get and Set for username
  public void setUsername(String username) {
    this.username = username;
  }
  public String getUsername() {
    return username;
  }

  // Get and Set for Name
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }

  // Get and Set for Password
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPassword() {
    return password;
  }
}
