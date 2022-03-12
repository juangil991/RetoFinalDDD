package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarNombreBarbero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarTipoDeDiseñoBarba;

public class ActualizarTipoDeDiseñoBarbaUseCase
        extends UseCase<RequestCommand<ActualizarTipoDeDiseñoBarba>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoDeDiseñoBarba> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.ActualizarTipoDeDiseñoBarba(command.getTipoDeDiseño());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
