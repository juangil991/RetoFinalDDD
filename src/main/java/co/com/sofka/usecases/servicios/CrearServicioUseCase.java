package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.CrearServicio;

public class CrearServicioUseCase extends UseCase<RequestCommand<CrearServicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearServicio> input) {
        var command = input.getCommand();
        var servicios=  new Servicios(command.getIdServicios(),command.getFechaDeServicio());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
