package io.github.joanicegaspar.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// Na Interface que estaremos criando, passaremos como parâmetro a Classe/entidade que levou-nos a criar tal interface que neste caso é  (UserModel) e o Tipo do Id desta mesma entidade que neste caso é (UUID)
// Apenas isto, é suficiente para que a interface faça o trabalho todo sozinha
// Ela vai gerar automaticamente e debaixo dos panos, todos os métodos que precisaremos 
public interface UserRepository extends JpaRepository<UserModel, UUID> {
  
  //Levar o Repositório a fazer um Select para buscar um usuário pelo ser UserName
  UserModel findByUsername(String username);
}
