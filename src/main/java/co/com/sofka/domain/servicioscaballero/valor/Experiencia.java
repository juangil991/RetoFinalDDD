package co.com.sofka.domain.servicioscaballero.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Experiencia implements ValueObject<Experiencia.Props> {
    private final String trabajosRealizados;
    private final Integer añosExperiencia;

    public Experiencia(String trabajosRealizados, Integer añosExperiencia) {
        this.trabajosRealizados = Objects.requireNonNull(trabajosRealizados);
        this.añosExperiencia = Objects.requireNonNull(añosExperiencia);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String TrabajosRealizados() {
                return trabajosRealizados;
            }

            @Override
            public Integer AñosExperiencia() {
                return añosExperiencia;
            }
        };
    }

    public interface Props{
        String TrabajosRealizados();
        Integer AñosExperiencia();
    }
}
