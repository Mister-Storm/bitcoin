package org.misterstorm.resource;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.misterstorm.model.Usuario;

@Path("/usuarios")
public class UsuarioRessource {
	
	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		
		Usuario.adicionar(usuario);
		
	}

}
