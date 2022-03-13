package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreEstilista;
import co.com.sofka.domain.serviciosdama.command.AgregarEsmalteManicurista;

public class AgregarEsmalteManicuristaUseCase
        extends UseCase<RequestCommand<AgregarEsmalteManicurista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEsmalteManicurista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.AgregarEsmalteManicurista(command.getEsmalte());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
