package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.AgregarCorteCaballero;

public class AgregarCorteCaballeroUseCase extends UseCase<RequestCommand<AgregarCorteCaballero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCorteCaballero> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.AgregarCorteCaballero(command.getIdCorteCaballero(),command.getComplejidad(),command.getEstiloCorte());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
