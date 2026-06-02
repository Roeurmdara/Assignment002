package co.istad.assigment003.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CoffeeRequest(
        @NotNull(message = "Code is required")
        Integer code,

        @Size(min = 3 , max = 100)
        @NotBlank(message = "Name is required")
        String name,

        @Size(min = 3, max =500)
        @NotBlank(message = "description is required")
        String description,



        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        Integer price
) {
}