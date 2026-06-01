package co.istad.assigment003.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CoffeeRequest(
        @NotNull(message = "Code is required")
        Integer code,


        @NotBlank(message = "Name is required")
        String name,


        @NotBlank(message = "description is required")
        String description,



        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        Integer price
) {
}