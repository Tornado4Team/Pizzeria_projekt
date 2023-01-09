package controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;;
    private String data;
    private double koszt;
    private boolean zrealizowane;

    @ManyToMany
    private Set<Pizza> pizzas;

    @ManyToOne
    private Osoba osoba;

    public Zamowienie(){
        this.data = "";
        this.koszt = 0.0;
        this.zrealizowane=false;
    }

    public Zamowienie(String data_order, double koszt, boolean zrealizowana) {
        this.data = data_order;
        this.koszt = koszt;
        this.zrealizowane = zrealizowana;
        pizzas = new HashSet<Pizza>();
        osoba = null;
    }

    @Override
    public String toString() {
        return String.format(data + " "+koszt);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {        return data;    }
    public void setData(String data_zamowienia) {        this.data = data_zamowienia;    }

    public double getKoszt() {        return koszt;    }
    public void setKoszt(double koszt) {        this.koszt = koszt;    }

    public boolean isZrealizowane() {        return zrealizowane;    }
    public void setZrealizowane(boolean zrealizowane) {        this.zrealizowane = zrealizowane;    }

    public Set<Pizza> getPizzas() {        return pizzas;    }
    public void setPizzas(Set<Pizza> pizzas) {        this.pizzas = pizzas;    }

    public Osoba getOsoba() {        return osoba;    }
    public void setOsoba(Osoba osoba) {        this.osoba = osoba;    }
}

