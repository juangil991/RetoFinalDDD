package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicios.command.ActualizarGeneroCliente;
import co.com.sofka.domain.servicios.command.CrearCliente;
import co.com.sofka.domain.servicios.event.ClienteCreado;
import co.com.sofka.domain.servicios.event.GeneroClienteActualizado;
import co.com.sofka.domain.servicios.event.ServiciosAgregado;
import co.com.sofka.domain.servicios.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarGeneroClienteUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void ActualizarGeneroClienteTest(){
        //arrange
        IdServicios idServicios = IdServicios.of("xxxx");
        IdCliente idCliente= IdCliente.of("xxx");
        Genero genero= new Genero("indefinido");
        var command =new ActualizarGeneroCliente(idServicios,idCliente,genero);
        var usecase= new ActualizarGeneroClienteUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicios.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(GeneroClienteActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.generoclienteactualizado",event.type);
        Assertions.assertEquals("xxx",event.getIdCliente().value());
        Assertions.assertEquals("indefinido",event.getGenero().value());

    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        IdCliente idCliente= IdCliente.of("xxx");
        Nombre nombre= new Nombre("maria","monsalve");
        Genero genero= new Genero("mujer");
        return List.of(
                new ServiciosAgregado(fechaDeServicio),
                new ClienteCreado(idCliente,nombre,genero)
        );
    }

}