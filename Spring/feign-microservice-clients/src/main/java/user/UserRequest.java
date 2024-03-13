package user;

public record UserRequest(
        Long toUserId,
        String toUserEmail,
        String message
) {
}