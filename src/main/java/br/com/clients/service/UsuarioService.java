package br.com.clients.service;

import br.com.clients.Repository.UsuarioReposioty;
import br.com.clients.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioReposioty reposioty;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //vai pegar o nome de usuario e trazer os dados
        Usuario usuario = reposioty.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Usuario não encontrado"));
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER").build()
                ;
    }
}
