package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.CortarBarba;

public class CortarBarbaUseCase extends UseCase<RequestCommand<CortarBarba>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CortarBarba> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.CortarBarba(command.getCorteBarba());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
