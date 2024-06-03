package io.github.joanicegaspar.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// A classe para criarmos um Objeto que será o Modelo de Usuário que nós pretendemos ter, daí o nome "UserModel".
// Este usuário terá: username, name e um password

//@Data - uma funcionalidade da Library Lombok
// Coloca automaticamente (por debaixo dos panos), os getters e setters de todos os atributos (username, name...)
// @Getter - caso queiramos apenas os getters
// @Setter - caso queiramos apenas os setters

@Data
@Entity(name = "tb_USERS")
public class UserModel {
  
  @Id // é uma forma de indicar que o id, será a Chave Primária (Primary Key)
  @GeneratedValue(generator = "UUID") // para que ele gere os Ids de forma automática
  private UUID id;

  @Column(unique = true)
  private String username;
  private String name;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
