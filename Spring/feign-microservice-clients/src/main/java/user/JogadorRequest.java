package user;

public record JogadorRequest(
        Long toJogadorId,
        String toJogadorName,
        String message
) {
}