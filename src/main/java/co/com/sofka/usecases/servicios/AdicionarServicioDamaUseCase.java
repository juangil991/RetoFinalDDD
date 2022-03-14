package co.com.sofka.usecases.servicios;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicios.Servicios;
import co.com.sofka.domain.servicios.command.AdicionarServicioDama;

public class AdicionarServicioDamaUseCase extends UseCase<RequestCommand<AdicionarServicioDama>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AdicionarServicioDama> input) {
        var command= input.getCommand();
        var servicios= Servicios.from(command
                .getIdServicios(),retrieveEvents());
        servicios.AdicionarServicioDama(command.getIdServiciosDama());
        emit().onResponse(new ResponseEvents(servicios.getUncommittedChanges()));
    }
}
