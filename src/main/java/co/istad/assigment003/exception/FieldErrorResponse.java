package co.istad.assigment003.exception;

public record FieldErrorResponse(
        String field,
        String message
) {
}
