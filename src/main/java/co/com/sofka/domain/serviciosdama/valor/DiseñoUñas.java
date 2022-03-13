package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class DiseñoUñas implements ValueObject<DiseñoUñas.Props> {
    private final String descripcionDiseño;
    private final String tipoDeUñas;

    public DiseñoUñas(String descripcionDiseño, String tipoDeUñas) {
        this.descripcionDiseño = descripcionDiseño;
        this.tipoDeUñas = tipoDeUñas;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String DescripcionDiseño() {
                return descripcionDiseño;
            }

            @Override
            public String TipoDeUñas() {
                return tipoDeUñas;
            }
        };
    }

    public interface Props{
        String DescripcionDiseño();
        String TipoDeUñas();
    }
}
