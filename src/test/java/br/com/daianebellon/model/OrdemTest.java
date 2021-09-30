package br.com.daianebellon.model;

import br.com.daianebellon.repository.OrdemRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

@QuarkusTest
public class OrdemTest {

    @InjectMock
    OrdemRepository ordemRepository;

    @Test
    public void testarSeListAllRetornaUsuariosComOrdensCorretas() {
        //mocks
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();
        ArrayList<Ordem> ordens = new ArrayList<>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(ordemRepository.listAll()).thenReturn(ordens);

        //assertivas
        Assertions.assertSame(segundaOrdem, ordemRepository.listAll().get(1));

    }

}