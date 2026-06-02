
package co.istad.assigment003.service.impl;

import co.istad.assigment003.domain.Coffee;
import co.istad.assigment003.dto.CoffeeRequest;
import co.istad.assigment003.dto.CoffeeResponse;
import org.springframework.stereotype.Service;
import co.istad.assigment003.repository.CoffeeRepository;
import co.istad.assigment003.service.CoffeeService;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<CoffeeResponse> getCoffee() {
        return coffeeRepository.findAll()
                .stream()
                .map(c -> new CoffeeResponse(
                        c.getId(),
                        c.getCode(),
                        c.getName(),
                        c.getPrice(),
                        c.getDescription()
                ))
                .toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Integer id) {

        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Coffee not found with id: " + id));

        return new CoffeeResponse(
                coffee.getId(),
                coffee.getCode(),
                coffee.getName(),
                coffee.getPrice(),
                coffee.getDescription()
        );
    }



    @Override
    public CoffeeResponse addCoffee(CoffeeRequest request) {
        if (coffeeRepository.existsByCode(request.code())) {
            throw new IllegalArgumentException("Coffee code already exists: " + request.code());
        }
        Coffee coffee = new Coffee();
        coffee.setCode(request.code());
        coffee.setName(request.name());
        coffee.setPrice(request.price());
        coffee.setDescription(request.description());
        Coffee saved = coffeeRepository.save(coffee);
        return new CoffeeResponse(
                saved.getId(),
                saved.getCode(),
                saved.getName(),
                saved.getPrice(),
                saved.getDescription()
        );
    }


    @Override
    public CoffeeResponse updateCoffee(Integer id, CoffeeRequest request) {

        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Coffee not found with id: " + id));

        if (!coffee.getCode().equals(request.code())
                && coffeeRepository.existsByCode(request.code())) {
            throw new IllegalArgumentException("Coffee code already exists: " + request.code());
        }

        coffee.setCode(request.code());
        coffee.setName(request.name());
        coffee.setPrice(request.price());
        coffee.setDescription(request.description());

        Coffee saved = coffeeRepository.save(coffee);

        return new CoffeeResponse(
                saved.getId(),
                saved.getCode(),
                saved.getName(),
                saved.getPrice(),
                saved.getDescription()
        );
    }

    @Override
    public String deleteCoffee(Integer id) {
        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Coffee not found with id: " + id));
        coffeeRepository.delete(coffee);
        return "Coffee with ID " + id + " has been successfully deleted.";
    }
}