package co.istad.assigment003.controller;

import co.istad.assigment003.dto.CoffeeRequest;
import co.istad.assigment003.dto.CoffeeResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import co.istad.assigment003.service.CoffeeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<CoffeeResponse> getAll() {
        log.info("Getting all coffees");
        return coffeeService.getCoffee();
    }

    @GetMapping("/{id}")
    public CoffeeResponse getById(@PathVariable Integer id) {
        return coffeeService.getCoffeeById(id);
    }



    @PostMapping
    public CoffeeResponse addCoffee(@Valid @RequestBody CoffeeRequest coffeeRequest) {
        return coffeeService.addCoffee(coffeeRequest);
    }

    @PatchMapping("/{id}")
    public CoffeeResponse updateCoffee(
            @PathVariable Integer id,
            @Valid @RequestBody CoffeeRequest coffeeRequest
    ) {
        return coffeeService.updateCoffee(id , coffeeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Integer id) {
        coffeeService.deleteCoffee(id);
    }
}