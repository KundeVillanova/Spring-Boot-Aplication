package br.com.clients.Repository;

import br.com.clients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    //interface para o repositorio passando o tipo da classe e o tipo da chave primaria
    //ja foi automaticamente configurado pelo spring data jpa
}
