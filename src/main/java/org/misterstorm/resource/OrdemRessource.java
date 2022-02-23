package org.misterstorm.resource;

import org.misterstorm.model.Ordem;
import org.misterstorm.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/ordens")
public class OrdemRessource {

	@Inject
	OrdemService service;
	
	@POST
	@RolesAllowed("user")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
		service.inserir(securityContext.getUserPrincipal().getName(), ordem);
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> listar() {
		return service.listar();
	}

}
