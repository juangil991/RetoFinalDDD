package co.com.sofka.usecases.serviciosdama;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.AgregarEstilista;

public class AgregarEstilistaUseCase extends UseCase<RequestCommand<AgregarEstilista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEstilista> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.AgregarEstilista(command.getIdEstilista(),command.getNombre());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
