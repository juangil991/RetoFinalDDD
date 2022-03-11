package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

public class CorteBarba implements ValueObject<CorteBarba.Props> {
    private final String descripcionCorte;
    private final String tipoDeBarba;

    public CorteBarba(String descripcionCorte, String tipoDeBarba) {
        this.descripcionCorte = descripcionCorte;
        this.tipoDeBarba = tipoDeBarba;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String DescripcionCorte() {
                return descripcionCorte;
            }

            @Override
            public String TipoDeBarba() {
                return tipoDeBarba;
            }
        };
    }

    public interface Props{
        String DescripcionCorte();
        String TipoDeBarba();
    }
}
