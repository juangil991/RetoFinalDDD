package co.com.sofka.domain.serviciosdama.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Alisado implements ValueObject<Alisado.Props> {
    private final String nombreAlisado;
    private final String descripcionAlisado;
    private final String productosUtilizados;

    public Alisado(String nombreAlisado, String descripcionAlisado, String productosUtilizados) {
        this.nombreAlisado = nombreAlisado;
        this.descripcionAlisado = descripcionAlisado;
        this.productosUtilizados = productosUtilizados;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String NombreAlisado() {
                return nombreAlisado;
            }

            @Override
            public String DescripcionAlisado() {
                return descripcionAlisado;
            }

            @Override
            public String ProductosUtilizados() {
                return productosUtilizados;
            }
        };
    }

    public interface Props{
        String NombreAlisado();
        String DescripcionAlisado();
        String ProductosUtilizados();
    }
}
