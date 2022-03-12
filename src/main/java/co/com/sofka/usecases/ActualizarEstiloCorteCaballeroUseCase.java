package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarEstiloCorteCaballero;

public class ActualizarEstiloCorteCaballeroUseCase
        extends UseCase<RequestCommand<ActualizarEstiloCorteCaballero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEstiloCorteCaballero> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.ActualizarEstiloCorteCaballero(command.getEstiloCorte());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
