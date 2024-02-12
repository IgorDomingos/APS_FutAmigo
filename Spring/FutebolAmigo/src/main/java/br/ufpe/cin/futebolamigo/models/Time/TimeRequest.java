package br.ufpe.cin.futebolamigo.models.Time;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Time}
 */
public record TimeRequest(@NotNull Long id,
                          @NotBlank String nome,
                          String gestorCpf,
                          @NotBlank String corP,
                          String corS,
                          String escudo) implements Serializable {
}