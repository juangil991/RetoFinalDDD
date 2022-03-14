package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.ActualizarGeneroCliente;

public class ActualizarGeneroClienteUseCase
        extends UseCase<RequestCommand<ActualizarGeneroCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarGeneroCliente> input) {
        var command= input.getCommand();
        var servicios= Servicios.from(command
                .getIdServicios(),retrieveEvents());
        servicios.ActualizarGeneroCliente(command.getIdCliente(),command.getGenero());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
