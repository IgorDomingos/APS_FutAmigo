package user;

public record GestorRequest(
        Long toGestorId,
        String toGestorName,
        String message
) {
}