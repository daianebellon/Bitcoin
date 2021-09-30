package br.com.daianebellon.repository;

import br.com.daianebellon.model.Ordem;
import br.com.daianebellon.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped()
public class OrdemRepository implements PanacheRepository<Ordem> {
}
