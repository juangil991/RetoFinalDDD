package co.com.sofka.usecases.serviciosdama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.serviciosdama.ServiciosDama;
import co.com.sofka.domain.serviciosdama.command.ActualizarNombreEstilista;
import co.com.sofka.domain.serviciosdama.command.AgregarCorteDama;

public class AgregarCorteDamaUseCase
        extends UseCase<RequestCommand<AgregarCorteDama>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCorteDama> input) {
        var command = input.getCommand();
        var serviciosDama= ServiciosDama
                .from(command.getIdServicioDama(),retrieveEvents());
        serviciosDama.AgregarCorteDama(command.getIdCortesDama(),command.getTipoDeCorte(),command.getTipoDeCabello());
        emit().onResponse(new ResponseEvents(serviciosDama.getUncommittedChanges()));
    }
}
