package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.serviciosdama.command.ActualizarTipoDeCabelloCorteDama;
import co.com.sofka.domain.serviciosdama.command.AgregarCorteDama;
import co.com.sofka.domain.serviciosdama.event.CorteDamaAgregado;
import co.com.sofka.domain.serviciosdama.event.ServiciosDamaCreado;
import co.com.sofka.domain.serviciosdama.event.TipoDeCabelloCorteDamaActualizado;
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
class ActualizarTipoDeCabelloCorteDamaUseCaseTest {

    @Mock
    public DomainEventRepository repository;

    @Test
    void ActualizarTipoDeCabelloCorteDamaTest(){
        //arrange
        IdServicioDama idServicioDama= IdServicioDama.of("xxxx");
        IdCortesDama idCortesDama = IdCortesDama.of("xxx");
        TipoDeCabello tipoDeCabello = new TipoDeCabello("Crespo","largo");
        var command = new ActualizarTipoDeCabelloCorteDama(idServicioDama,idCortesDama,tipoDeCabello);
        var usecase = new ActualizarTipoDeCabelloCorteDamaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idServicioDama.value())
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event=(TipoDeCabelloCorteDamaActualizado)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciosdama.tipodecabellocortedamaactualizado",event.type);
        Assertions.assertEquals("Crespo",event.getTipoDeCabello().value().DescripcionTipoDeCabello());
        Assertions.assertEquals("largo",event.getTipoDeCabello().value().TamañoCabello());
    }

    private List<DomainEvent> history() {
        FechaDeServicio fechaDeServicio= new FechaDeServicio();
        TipoDeCabello tipoDeCabello = new TipoDeCabello("ondulado","corto");
        TipoDeCorte tipoDeCorte = new TipoDeCorte("puntas","cortesencillo");
        return List.of(
                new ServiciosDamaCreado(fechaDeServicio),
                new CorteDamaAgregado(IdCortesDama.of("xxx"),tipoDeCorte,tipoDeCabello)
        );
    }

}