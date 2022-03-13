package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarNombreBarbero;

public class ActualizarNombreBarberoUseCase
        extends UseCase<RequestCommand<ActualizarNombreBarbero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreBarbero> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.ActualizarNombreBarbero(command.getIdBarbero(),command.getNombre());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
