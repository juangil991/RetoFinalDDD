package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.ActualizarDiseñoUñasManicurista;
import co.com.sofka.domain.serviciosdama.command.AgregarManicurista;
import co.com.sofka.domain.serviciosdama.event.DiseñoUñasManicuristaActualizado;
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
class ActualizarDiseñoUñasManicuristaUseCaseTest {


    @Mock
    public DomainEventRepository repository;

    @Test
    void ActualizarDiseñoUñasManicuristaTest(){
        IdServicioDama idServicioDama = IdServicioDama.of("xxxx");
        IdManicurista idManicurista = IdManicurista.of("xxx");
        DiseñoUñas diseñoUñas= new DiseñoUñas("comun","acrilicas");
        var command=new ActualizarDiseñoUñasManicurista(idServicioDama,idManicurista,diseñoUñas);
        var usecase= new ActualizarDiseñoUñasManicuristaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(DiseñoUñasManicuristaActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.diseñouñasmanicuristaactualizado",event.type);
        Assertions.assertEquals("xxx",event.getIdManicurista().value());
        Assertions.assertEquals("comun",event.getDiseñoUñas().value().DescripcionDiseño());
        Assertions.assertEquals("acrilicas",event.getDiseñoUñas().value().TipoDeUñas());
    }
    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        IdManicurista idManicurista = IdManicurista.of("xxx");
        Nombre nombre = new Nombre("luis", "yepes");
        DiseñoUñas diseñoUñas= new DiseñoUñas("personalizadas","largas");
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio),
                new ManicuristaAgregada(idManicurista,nombre,diseñoUñas)
        );
    }

}