package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.ActualizarDiseñoUñasManicurista;

public class ActualizarDiseñoUñasManicuristaUseCase
        extends UseCase<RequestCommand<ActualizarDiseñoUñasManicurista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDiseñoUñasManicurista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.ActualizarDiseñoUñasManicurista(command.getIdManicurista(),command.getDiseñoUñas());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
