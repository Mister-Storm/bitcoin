package org.misterstorm.repository;

import javax.enterprise.context.ApplicationScoped;

import org.misterstorm.model.Ordem;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem>{
	

}
