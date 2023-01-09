package controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nazwa;
    private double koszt;

    @ManyToMany
    private Set<Skladnik> skladniki;
    @ManyToMany
    private Set<Zamowienie> zamowienia;

    public Pizza(){
        this.nazwa = "";
        this.koszt=0.0;
    }



    public Pizza(String nazwa, double koszt) {
        this.nazwa = nazwa;
        this.koszt = koszt;
        skladniki = new HashSet<Skladnik>();
        zamowienia = new HashSet<Zamowienie>();
    }

    @Override
    public String toString() {
        return String.format(nazwa);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {        return nazwa;    }
    public void setNazwa(String nazwa) {        this.nazwa = nazwa;    }

    public double getKoszt() {        return koszt;    }
    public void setKoszt(double koszt) {        this.koszt = koszt;    }

    public Set<Skladnik> getSkladniki() {        return skladniki;    }
    public void setSkladniki(Set<Skladnik> skladniki) {        this.skladniki = skladniki;    }
    public void clearSkladniki() {        skladniki = new HashSet<Skladnik>();    }


    public Set<Zamowienie> getZamowienia() {        return zamowienia;    }
    public void setZamowienia(Set<Zamowienie> zamowienia) {        this.zamowienia = zamowienia;    }
}

