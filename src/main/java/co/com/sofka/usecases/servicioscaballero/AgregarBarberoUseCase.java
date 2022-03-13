package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.AgregarBarbero;

public class AgregarBarberoUseCase extends UseCase<RequestCommand<AgregarBarbero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarBarbero> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.AgregarBarbero(command.getIdBarbero(),command.getNombre(), command.getExperiencia());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
