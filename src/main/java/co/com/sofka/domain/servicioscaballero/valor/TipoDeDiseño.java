package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

public class TipoDeDiseño implements ValueObject<TipoDeDiseño.Props> {
    private final String nombreDiseño;
    private final String descripcionDiseño;

    public TipoDeDiseño(String nombreDiseño, String descripcionDiseño) {
        this.nombreDiseño = nombreDiseño;
        this.descripcionDiseño = descripcionDiseño;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String NombreDiseño() {
                return nombreDiseño;
            }

            @Override
            public String DescripcionDiseño() {
                return descripcionDiseño;
            }
        };
    }

    public interface Props{
        String NombreDiseño();
        String DescripcionDiseño();
    }
}
