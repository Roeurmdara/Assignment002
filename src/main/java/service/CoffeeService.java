package co.istad.assigment003.service;

import co.istad.assigment003.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {

    List<CoffeeResponse> getCoffee();

    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse> searchCoffee(String name, Integer price);
}