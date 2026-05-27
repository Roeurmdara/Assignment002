package repository;

import domain.Coffee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepository {

    public List<Coffee> findAll(){
        Coffee coffee1 = new Coffee(1,"Ice Latte","50%");
        Coffee coffee2 = new Coffee(2,"Ice Latte","50%");
        Coffee coffee3 = new Coffee(3,"Ice Latte2","110%");
        Coffee coffee4 = new Coffee(34,"Ice Latte3","30%");
        Coffee coffee5 = new Coffee(53,"Ice Latte4","60%");
        Coffee coffee6 = new Coffee(1,"Ice Latte5","20%");

        return new ArrayList<>(List.of(
                coffee1,
                coffee2,
                coffee3,
                coffee4,
                coffee5,
                coffee6
        ));
    }
}