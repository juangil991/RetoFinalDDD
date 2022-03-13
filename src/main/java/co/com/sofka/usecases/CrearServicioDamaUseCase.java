package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.CrearServicioDama;

public class CrearServicioDamaUseCase extends UseCase<RequestCommand<CrearServicioDama>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearServicioDama> input) {
        var command = input.getCommand();
        var serviciosDama= new ServiciosDama(command.getIdServicioDama(),command.getFechaDeServicio());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
