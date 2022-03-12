package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.servicioscaballero.command.CortarBarba;
import co.com.sofka.domain.servicioscaballero.event.BarbaCortada;
import co.com.sofka.domain.servicioscaballero.event.ServiciosCaballeroCreado;
import co.com.sofka.domain.servicioscaballero.valor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CortarBarbaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void CortarBarbaTest(){
    //arrange
    IdServiciosCaballero idServiciosCaballero= IdServiciosCaballero.of("xxxx");
        CorteBarba corteBarba = new CorteBarba("CorteTotal","Larga");
    var command= new CortarBarba(idServiciosCaballero,corteBarba);
    var usecase= new CortarBarbaUseCase();
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        usecase.addRepository(repository);

    //act
    var events = UseCaseHandler.getInstance()
            .setIdentifyExecutor(idServiciosCaballero.value())
            .syncExecutor(usecase,new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    //assert
    var event = (BarbaCortada)events.get(0);
        Assertions.assertEquals("co.com.sofka.domain.serviciocaballero.barbacortada",
    event.type);
        Assertions.assertEquals("CorteTotal",event.getCorteBarba().value().DescripcionCorte());
        Assertions.assertEquals("Larga",event.getCorteBarba().value().TipoDeBarba());

}
    private List<DomainEvent> history() {
        Date Fecha = new Date(2022,03,11);
        FechaDeServicio fechaDeServicio = new FechaDeServicio(Fecha);
        return List.of(
                new ServiciosCaballeroCreado(fechaDeServicio)
        );
    }
}