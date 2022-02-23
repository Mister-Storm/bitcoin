package org.misterstorm.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UsuarioTest {

    @Test
    public void testarSeFindByOptionalRetornaOUsuarioCorreto(){
        PanacheMock.mock(Usuario.class);
        Usuario usuario = new Usuario();
        Optional<PanacheEntityBase> optionalUsuario = Optional.of(usuario);
        Mockito.when(Usuario.findByIdOptional(40)).thenReturn(optionalUsuario);
        assertSame(usuario, Usuario.findByIdOptional(40).get());


    }

}