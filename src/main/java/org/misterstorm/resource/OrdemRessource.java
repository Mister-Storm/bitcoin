package org.misterstorm.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.misterstorm.model.Ordem;
import org.misterstorm.repository.OrdemRepository;

@Path("/ordens")
public class OrdemRessource {

	@Inject
	OrdemRepository repository;
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		repository.persist(ordem);
	}
}
