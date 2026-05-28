package co.istad.assigment003.controller;

import co.istad.assigment003.dto.CoffeeResponse;
import co.istad.assigment003.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<CoffeeResponse> getAll() {
        return coffeeService.getCoffee();
    }

    @GetMapping("/{id}")
    public CoffeeResponse getById(@PathVariable Integer id) {
        return coffeeService.getCoffeeById(id);
    }
    @GetMapping("/search")
    public List<CoffeeResponse> searchCoffee(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer price
    ) {
        return coffeeService.searchCoffee(name, price);
    }
}