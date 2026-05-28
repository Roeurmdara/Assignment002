package co.istad.assigment003.service.impl;

import co.istad.assigment003.domain.Coffee;
import co.istad.assigment003.dto.CoffeeResponse;
import co.istad.assigment003.repository.CoffeeRepository;
import co.istad.assigment003.service.CoffeeService;
import org.springframework.stereotype.Service;

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
                        c.getName(),
                        c.getPrice(),
                        c.getDescription()
                ))
                .toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Integer id) {

        Coffee coffee = coffeeRepository.findById(id);

        if (coffee == null) {
            throw new RuntimeException("Coffee not found");
        }

        return new CoffeeResponse(
                coffee.getId(),
                coffee.getName(),
                coffee.getPrice(),
                coffee.getDescription()
        );
    }
    @Override
    public List<CoffeeResponse> searchCoffee(String name, Integer price) {

        return coffeeRepository.search(name, price)
                .stream()
                .map(c -> new CoffeeResponse(
                        c.getId(),
                        c.getName(),
                        c.getPrice(),
                        c.getDescription()
                ))
                .toList();
    }
}