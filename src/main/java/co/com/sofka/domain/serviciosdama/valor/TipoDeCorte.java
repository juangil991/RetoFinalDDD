package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class TipoDeCorte implements ValueObject<TipoDeCorte.Props> {
    private final String descripcionCorte;
    private final String nombreCorte;

    public TipoDeCorte(String descripcionCorte, String nombreCorte) {
        this.descripcionCorte = descripcionCorte;
        this.nombreCorte = nombreCorte;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String DescripcionCorte() {
                return descripcionCorte;
            }

            @Override
            public String NombreCorte() {
                return nombreCorte;
            }
        };
    }

    public interface Props{
        String DescripcionCorte();
        String NombreCorte();
    }
}
