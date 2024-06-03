package io.github.joanicegaspar.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificador:
 *  - public (par defaut)
 *  - private
 *  - protected
 * 
 * Acessar o Banco de Dados no Browser:
 * http://localhost:8080/h2-console
 */
@RestController
@RequestMapping("/users")
public class UserController {

  // Aqui, eu quero receber os dados do usuário
  // Estes dados ficarão dentro do corpo (body) da página, não no header por exemplo
  // Então vamos recorrer ao "@RequestBody" para que os dados venham jáestruturados dentro do corpo da página
  // E como estaremos "Criando" algo (o nosso modelo de usuário(objeto)) então vamos usar o Método Post. (PostMapping())
  //@Autowired: cria automaticamente e debaixo dos panos todos os métodos e instaciações da classe que nós chamarmos

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if(user != null) {
      // Apresentar o Status Code + Mensagem de erro
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("este Usuário já existe!");
    }

    var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
    userModel.setPassword(passwordHashred);

    //Caso contrário, significa que o user ainda não existe
    // Vamos criar o usuário e guardar as suas informções
    var userCreated = this.userRepository.save(userModel);
    
    // Vamos Retornar ou Apresentar o Status Code de sucesso + As informações registradas
    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
   
  }
}
