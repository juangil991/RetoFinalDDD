package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.ActualizarNombreCliente;

public class ActualizarNombreClienteUseCase
        extends UseCase<RequestCommand<ActualizarNombreCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCliente> input) {
        var command= input.getCommand();
        var servicios= Servicios.from(command
                .getIdServicios(),retrieveEvents());
        servicios.ActualizarNombreCliente(command.getIdCliente(),command.getNombre());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
