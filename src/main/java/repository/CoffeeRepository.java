package co.istad.assigment003.repository;

import co.istad.assigment003.domain.Coffee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository {

    public List<Coffee> findAll() {

        return new ArrayList<>(List.of(
                new Coffee(1, 1, "Ice Latte", "50%" ,23),
                new Coffee(2, 2, "Americano", "0%",32),
                new Coffee(3, 3, "Cappuccino", "30%",33),
                new Coffee(4, 4, "Mocha", "70%",45)
        ));
    }

    public Coffee findById(Integer id) {

        return findAll()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public List<Coffee> search(String name, Integer price) {

        return findAll().stream()
                .filter(c -> name == null ||
                        c.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(c -> price == null ||
                        c.getCode().equals(price))
                .toList();
    }
}