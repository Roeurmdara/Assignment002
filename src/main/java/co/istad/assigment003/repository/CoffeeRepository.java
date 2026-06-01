package co.istad.assigment003.repository;

import co.istad.assigment003.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {
    boolean existsByCode(Integer code);
}