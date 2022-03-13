package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.AgregarAlisadoEstilista;
import co.com.sofka.domain.serviciosdama.command.AgregarEstilista;
import co.com.sofka.domain.serviciosdama.event.AlisadoEstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.EstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.ServiciosDamaCreado;
import co.com.sofka.domain.serviciosdama.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarEstilistaUseCaseTest {
    @Mock
    public DomainEventRepository repository;

    @Test
    void AgregarEstilistaTest(){
        //arrange
        IdServicioDama idServicioDama= IdServicioDama.of("xxxx");
        IdEstilista idEstilista= IdEstilista.of("xxx");
        Nombre nombre = new Nombre("luis","yepes");
        var command =new AgregarEstilista(idServicioDama,idEstilista,nombre);
        var usecase= new AgregarEstilistaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(EstilistaAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.estilistaagregado",event.type);
    }
    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio)
        );
    }
}