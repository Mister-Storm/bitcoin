package org.misterstorm.service;

import org.misterstorm.model.Ordem;
import org.misterstorm.model.Usuario;
import org.misterstorm.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped()
public class OrdemService {


    @Inject
    OrdemRepository repository;

    public void inserir(String usuarioQueEnviouOrdem, Ordem ordem) {

        Optional<Usuario> user = Usuario.findByIdOptional(ordem.getId());
        Usuario usuario = user.orElseThrow();
        if(!usuarioQueEnviouOrdem.equals(usuario.getUsername())) {
            throw new RuntimeException("Usuário logado diferente do usuário da ordem!");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        repository.persist(ordem);
    }

    public List<Ordem> listar() {
        return repository.listAll();
    }
}
