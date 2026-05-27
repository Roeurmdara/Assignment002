package service.Impl;

import domain.Coffee;
import dto.CoffeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CoffeeRepository;
import service.CoffeeService;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {


    private CoffeeRepository coffeeRepository;

    @Autowired
    public void setCoffeeRepository(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<CoffeeResponse> getCoffee() {
        List<Coffee> coffees = coffeeRepository.findAll();

        return coffees.stream().filter((d) -> d.getCode() > 2).map(
                (d) -> new CoffeeResponse(d.getName(), d.getDescription())
        ).toList();
    }
}