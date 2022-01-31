package org.misterstorm.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.misterstorm.model.Usuario;

@Path("/usuarios")
public class UsuarioRessource {
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		System.out.println(usuario.getPassword());
		Usuario.persist(usuario);
		
	}

}
