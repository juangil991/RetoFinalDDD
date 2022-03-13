package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.AgregarAlisadoEstilista;

public class AgregarAlisadoUseCase extends UseCase<RequestCommand<AgregarAlisadoEstilista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAlisadoEstilista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.AgregarAlisadoEstilista(command.getAlisado());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
