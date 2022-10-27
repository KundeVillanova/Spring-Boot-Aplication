package br.com.clients.rest;

import br.com.clients.Repository.ClientRepository;
import br.com.clients.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    private final ClientRepository repository;
    @Autowired
    public ClientController(ClientRepository repository){
        this.repository=repository;
    }


    @GetMapping
    public List<Client> getAll(){
        //metodo que vai listar os clientes
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid  Client client){
        return repository.save(client);
    }


    @GetMapping("{id}")
    public Client findClient(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Integer id){
        repository.findById(id).map(client -> {
            repository.delete(client);
            return Void.TYPE;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PutMapping("{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody Client clientup){
        repository.findById(id).map(client -> {
            clientup.setId(client.getId());
            return repository.save(clientup);
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
