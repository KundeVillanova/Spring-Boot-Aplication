package br.com.clients;

import br.com.clients.Repository.ClientRepository;
import br.com.clients.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientsApplication {

//    @Bean
//    public CommandLineRunner run(@Autowired ClientRepository repository){
//        return args -> {
//            Client client =  Client.builder().cpf("00000000000").name("Jeferson").build();
//            repository.save(client);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ClientsApplication.class, args);


    }

}
