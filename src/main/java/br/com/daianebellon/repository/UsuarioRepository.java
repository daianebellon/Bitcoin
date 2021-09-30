package br.com.daianebellon.repository;

import br.com.daianebellon.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped()  /*a classe terá uma unica instancia para todo_o_projeto */
public class UsuarioRepository implements PanacheRepository<Usuario> {
}
