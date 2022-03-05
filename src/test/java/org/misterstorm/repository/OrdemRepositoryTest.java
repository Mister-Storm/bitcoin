package org.misterstorm.repository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.misterstorm.model.Ordem;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class OrdemRepositoryTest {

    @InjectMock
    OrdemRepository repository;

    @Test
    void testarSeListAllRetornaUsuariosOrdensCorreta() {

        Ordem terceiraOrdem = new Ordem();
        List<Ordem> ordens = List.of(new Ordem(), new Ordem(), terceiraOrdem);

        Mockito.when(repository.listAll()).thenReturn(ordens);

        assertSame(terceiraOrdem, repository.listAll().get(2));

    }

}