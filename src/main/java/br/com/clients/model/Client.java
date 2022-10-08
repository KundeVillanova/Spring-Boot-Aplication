package br.com.clients.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull
    private String cpf;

    @Column(name = "ClientDate", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @PrePersist
    public void prePersist(){
        setDate(LocalDate.now());
    }


}
