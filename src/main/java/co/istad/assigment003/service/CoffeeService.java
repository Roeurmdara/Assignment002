package co.istad.assigment003.service;



import co.istad.assigment003.dto.CoffeeRequest;
import co.istad.assigment003.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {
    List<CoffeeResponse> getCoffee();
    CoffeeResponse getCoffeeById(Integer id);
    CoffeeResponse addCoffee(CoffeeRequest coffeeRequest);
    CoffeeResponse updateCoffee(Integer id, CoffeeRequest coffeeRequest);
    void deleteCoffee(Integer id);
}