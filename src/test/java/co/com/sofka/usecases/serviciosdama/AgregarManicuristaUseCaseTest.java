package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.AgregarManicurista;
import co.com.sofka.domain.serviciosdama.event.ManicuristaAgregada;
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
class AgregarManicuristaUseCaseTest {

    @Mock
    public DomainEventRepository repository;


    @Test
    void AgregarManicuristaTest() {
        IdServicioDama idServicioDama = IdServicioDama.of("xxxx");
        IdManicurista idManicurista = IdManicurista.of("xxx");
        Nombre nombre = new Nombre("luis", "yepes");
        DiseñoUñas diseñoUñas= new DiseñoUñas("kjslkdf","jasdflkj");
        var command=new AgregarManicurista(idServicioDama,idManicurista,nombre,diseñoUñas);
        var usecase= new AgregarManicuristaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(ManicuristaAgregada)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.manicuristaagregada",event.type);
    }
    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio)
        );
    }

}