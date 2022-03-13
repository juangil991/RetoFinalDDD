package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreManicurista;
import co.com.sofka.domain.serviciosdama.command.AgregarEsmalteManicurista;
import co.com.sofka.domain.serviciosdama.event.EsmalteManicuristaAgregado;
import co.com.sofka.domain.serviciosdama.event.ManicuristaAgregada;
import co.com.sofka.domain.serviciosdama.event.NombreDeManicuristaActualizado;
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
class AgregarEsmalteManicuristaUseCaseTest {

    @Mock
    public DomainEventRepository repository;

    @Test
    void AgregarEsmalteManicuristaTest(){
        IdServicioDama idServicioDama = IdServicioDama.of("xxxx");
        IdManicurista idManicurista = IdManicurista.of("xxx");
        Esmalte esmalte = new Esmalte("generica","Rojo");
        var command=new AgregarEsmalteManicurista(idServicioDama,idManicurista,esmalte);
        var usecase= new AgregarEsmalteManicuristaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(EsmalteManicuristaAgregado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.esmalteagregado",event.type);
        Assertions.assertEquals("generica",event.getEsmalte().value().Marca());
        Assertions.assertEquals("Rojo",event.getEsmalte().value().Color());
    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        Nombre nombre = new Nombre("luis", "yepes");
        DiseñoUñas diseñoUñas = new DiseñoUñas("comun","cortas");
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio),
                new ManicuristaAgregada(IdManicurista.of("xxx"),nombre,diseñoUñas)
        );
    }

}