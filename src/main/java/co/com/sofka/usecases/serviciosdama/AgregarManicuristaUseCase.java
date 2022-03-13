package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.AgregarManicurista;

public class AgregarManicuristaUseCase extends UseCase<RequestCommand<AgregarManicurista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarManicurista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.AgregarManicurista(command.getIdManicurista(),command.getNombre(),command.getDiseñoUñas());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));

    }
}
