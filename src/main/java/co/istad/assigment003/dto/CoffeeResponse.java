package co.istad.assigment003.dto;

public record CoffeeResponse(
        Integer id,
        Integer code,
        String name,
        Integer price,
        String description
) {
}