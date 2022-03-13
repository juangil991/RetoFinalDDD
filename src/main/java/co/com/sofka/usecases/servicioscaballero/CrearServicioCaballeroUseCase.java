package co.com.sofka.usecases.servicioscaballero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.CrearServicioCaballero;

public class CrearServicioCaballeroUseCase extends UseCase<RequestCommand<CrearServicioCaballero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearServicioCaballero> input) {
        var command=input.getCommand();
        var servicioCaballero= new ServiciosCaballero(command.getIdServiciosCaballero(),command.getFechaDeServicio());
        emit().onResponse(new ResponseEvents(servicioCaballero.getUncommittedChanges()));

    }
}
