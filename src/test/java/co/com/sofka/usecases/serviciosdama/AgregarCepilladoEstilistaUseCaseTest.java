package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreEstilista;
import co.com.sofka.domain.serviciosdama.command.AgregarCepilladoEstilista;
import co.com.sofka.domain.serviciosdama.event.CepilladoEstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.EstilistaAgregado;
import co.com.sofka.domain.serviciosdama.event.NombreEstilistaActualizado;
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
class AgregarCepilladoEstilistaUseCaseTest {
    @Mock
    public DomainEventRepository repository;

    @Test
    void AgregarCepilladoEstilistaTest(){
        //arrange
        IdServicioDama idServicioDama= IdServicioDama.of("xxxx");
        IdEstilista idEstilista= IdEstilista.of("xxx");
        Cepillado cepillado = new Cepillado("cepillado","largo");
        var command =new AgregarCepilladoEstilista(idServicioDama,idEstilista,cepillado);
        var usecase= new AgregarCepilladoEstilistaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(CepilladoEstilistaAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.cepilladoestilistaagregado",event.type);
        Assertions.assertEquals("cepillado",event.getCepillado().value().DescripcionCepillado());
        Assertions.assertEquals("largo",event.getCepillado().value().TamañoDelCabello());

    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        Nombre nombre = new Nombre("luis","yepes");
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio),
                new EstilistaAgregado(IdEstilista.of("xxx"),nombre)
        );
    }

}