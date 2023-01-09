package controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findByNazwa(String nazwa);
}
