package org.misterstorm.resource;

import java.time.LocalDate;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.misterstorm.model.Ordem;
import org.misterstorm.repository.OrdemRepository;
import org.misterstorm.service.OrdemService;

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
}
