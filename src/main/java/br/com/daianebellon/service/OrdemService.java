package br.com.daianebellon.service;

import br.com.daianebellon.model.Ordem;
import br.com.daianebellon.repository.OrdemRepository;
import br.com.daianebellon.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrdemService  {

    @Inject
    OrdemRepository ordemRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        var usuario = usuarioRepository.findByIdOptional(ordem.getUserId()).orElseThrow();

        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new IllegalArgumentException("Usuario inválido! É diferente do usuário logado");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listar() {
        return ordemRepository.listAll();
    }

}
