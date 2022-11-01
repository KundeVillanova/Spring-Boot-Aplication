package br.com.clients.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotEmpty(message = "{campo.descri.obri}")
    private String description;

    @NotEmpty(message = "{campo.price.obri}")
    private String price;

    @NotEmpty(message = "{campo.data.obri}")
    private String data;

    @NotNull(message = "{campo.client.obri}")
    private Integer idClient;

}
