package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarEstiloCorteCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarExperienciaBarbero;

public class ActualizarExperienciaBarberoUseCase
        extends UseCase<RequestCommand<ActualizarExperienciaBarbero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarExperienciaBarbero> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.ActualizarExperienciaBarbero(command.getIdBarbero(),command.getExperiencia());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
