package controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skladnik {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nazwa_skladnika;

    @ManyToMany
    private Set<Pizza> pizzas;



    public Skladnik(){
        this.nazwa_skladnika="";
       // pizzas = new HashSet<Pizza>();
    }

    public Skladnik(String nazwa) {
        this.nazwa_skladnika=nazwa;
        pizzas = new HashSet<Pizza>();
    }


    @Override
    public String toString() {
        return String.format(nazwa_skladnika);
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa_skladnika() {        return nazwa_skladnika;    }
    public void setNazwa_skladnika(String nazwa_skladnika) {        this.nazwa_skladnika = nazwa_skladnika;    }

    public Set<Pizza> getPizzas() {        return pizzas;    }
    public void setPizzas(Set<Pizza> pizzas) {        this.pizzas = pizzas;    }
}


