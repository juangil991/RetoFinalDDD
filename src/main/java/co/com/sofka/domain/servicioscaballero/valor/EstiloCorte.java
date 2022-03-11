package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstiloCorte implements ValueObject<EstiloCorte.Props> {
    private final String nombreCorte;
    private final String descripcionCorte;

    public EstiloCorte(String nombreCorte, String descripcionCorte) {
        this.nombreCorte = Objects.requireNonNull(nombreCorte) ;
        this.descripcionCorte = Objects.requireNonNull(descripcionCorte);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String NombreCorte() {
                return nombreCorte;
            }

            @Override
            public String DescripcionCorte() {
                return descripcionCorte;
            }
        };
    }

    public interface Props{
        String NombreCorte();
        String DescripcionCorte();
    }
}
