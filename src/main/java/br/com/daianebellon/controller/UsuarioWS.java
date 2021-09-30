package br.com.daianebellon.controller;

import br.com.daianebellon.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
public class UsuarioWS {

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        Usuario.inserir(usuario);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        System.out.println("caiu");
        return Usuario.listAll();
    }

}
