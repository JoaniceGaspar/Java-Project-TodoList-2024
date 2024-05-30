package io.github.joanicegaspar.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Modificador:
 *  - public (par defaut)
 *  - private
 *  - protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

  // Aqui, eu quero receber os dados do usuário
  // Estes dados ficarão dentro do corpo (body) da página, não no header por exemplo
  // Então vamos recorrer ao "@RequestBody" para que os dados venham jáestruturados dentro do corpo da página
  // E como estaremos "Criando" algo (o nosso modelo de usuário(objeto)) então vamos usar o Método Post

  @PostMapping("/")
  public void create(@RequestBody UserModel userModel) {
    System.out.println("O Lombok Funcionou! Brovo, " + userModel.getName());
  }
}
