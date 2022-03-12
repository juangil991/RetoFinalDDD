package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.servicioscaballero.ServiciosCaballero;
import co.com.sofka.domain.servicioscaballero.command.ActualizarTipoDeDiseñoBarba;
import co.com.sofka.domain.servicioscaballero.command.AgregarCorteCaballero;
import co.com.sofka.domain.servicioscaballero.command.AgregarDiseñoBarba;

public class AgregarDiseñoBarbaUseCase extends UseCase<RequestCommand<AgregarDiseñoBarba>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDiseñoBarba> input) {
        var command = input.getCommand();
        var serviciosCaballero= ServiciosCaballero
                .from(command.getIdServiciosCaballero(),retrieveEvents());
        serviciosCaballero.AgregarDiseñoBarba(command.getIdDiseñoBarba(),command.getTipoDeDiseño());
        emit().onResponse(new ResponseEvents(serviciosCaballero.getUncommittedChanges()));
    }
}
