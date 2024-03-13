package time;

public record TimeRequest(
        Long toTimeId,
        String toTimeName,
        String message
) {
}