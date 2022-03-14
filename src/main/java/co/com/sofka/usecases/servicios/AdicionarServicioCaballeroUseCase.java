package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.AdicionarServicioCaballero;

public class AdicionarServicioCaballeroUseCase
        extends UseCase<RequestCommand<AdicionarServicioCaballero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AdicionarServicioCaballero> input) {
        var command= input.getCommand();
        var servicios= Servicios.from(command
                .getIdServicios(),retrieveEvents());
        servicios.AdicionarServiciosCaballero(command.getIdServiciosCaballero());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
