package controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkladnikRepository extends JpaRepository<Skladnik, Long> {
    List<Skladnik> findByPizzasNazwa(String nazwa);

}
