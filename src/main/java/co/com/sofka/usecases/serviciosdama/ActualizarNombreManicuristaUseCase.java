package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreManicurista;

public class ActualizarNombreManicuristaUseCase
        extends UseCase<RequestCommand<ActualizarNombreManicurista>,ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreManicurista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.ActualizarNombreManicurista(command.getIdManicurista(),command.getNombre());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
