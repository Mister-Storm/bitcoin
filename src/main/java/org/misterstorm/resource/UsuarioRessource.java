package org.misterstorm.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.misterstorm.model.Usuario;

import java.util.List;

@Path("/usuarios")
public class UsuarioRessource {
	
	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		
		Usuario.adicionar(usuario);
		
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return PanacheEntityBase.listAll();
	}

}
