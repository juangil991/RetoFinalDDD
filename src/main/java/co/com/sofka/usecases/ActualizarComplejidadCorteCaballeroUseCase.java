package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarComplejidadCorteCaballero;


public class ActualizarComplejidadCorteCaballeroUseCase
        extends UseCase<RequestCommand<ActualizarComplejidadCorteCaballero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarComplejidadCorteCaballero> input) {
        var command= input.getCommand();
        var servicioscaballero= ServiciosCaballero.from(command
                .getIdServiciosCaballero(),retrieveEvents());
        servicioscaballero.ActualizarComplejidadCorteCaballero(command.getComplejidad());
        emit().onResponse(new ResponseEvents(servicioscaballero.getUncommittedChanges()));
    }

}
