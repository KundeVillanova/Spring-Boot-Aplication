package br.com.clients.Repository;

import br.com.clients.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioReposioty extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
}
