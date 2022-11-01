package br.com.clients.rest;

import br.com.clients.Repository.ClientRepository;
import br.com.clients.Repository.ProductRepository;
import br.com.clients.model.Client;
import br.com.clients.model.Product;
import br.com.clients.rest.DTO.ProductDTO;
import br.com.clients.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    //requiredArgs ali para fazer a injecao
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody @Valid ProductDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idClient = dto.getIdClient();

        Client client = clientRepository.findById(idClient).orElseThrow(()-> new ResponseStatusException(
           HttpStatus.BAD_REQUEST, "Cliente não existe"
        ));

        Product product = new Product();
        product.setDescription(dto.getDescription());
        product.setData(data);
        product.setClient(client);
        product.setPrice(bigDecimalConverter.converter(dto.getPrice()));
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> pesquisar(
            @RequestParam(value = "name", required = false, defaultValue = "")String name,
            @RequestParam(value = "mes", required = false)Integer mes)
    {
        return productRepository.findByNameAndMes("%"+name +"%", mes);
    }



}
