package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.CrearCliente;


public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> input) {
        var command= input.getCommand();
        var servicios= Servicios.from(command
                .getIdServicios(),retrieveEvents());
        servicios.AgregarCiente(command.getIdCliente(),command.getNombre(),command.getGenero());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
