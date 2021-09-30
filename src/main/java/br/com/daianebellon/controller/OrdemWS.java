package br.com.daianebellon.controller;

import br.com.daianebellon.model.Ordem;
import br.com.daianebellon.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/ordens")
public class OrdemWS {

    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
       ordemService.inserir(securityContext, ordem);
    }

    @GET
    @RolesAllowed(("admin"))
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar() {
        return  ordemService.listar();
    }
}
