package controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Osoba {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
    private String miasto;
    private String poczta;
    private String ulica;
    private String mieszkanie;
    private String login;
    private String haslo;
    private String typ;

    @OneToMany(mappedBy = "osoba")
    private Set<Zamowienie> zamowienia;



    public Osoba(){
        this.imie="";
        this.nazwisko="";
        this.email="";
        this.telefon="";
        this.miasto="";
        this.poczta="";
        this.ulica="";
        this.mieszkanie="";
        this.login="";
        this.haslo="";
        this.typ="";
    }

    public Osoba(String imie, String nazwisko, String data_urodzenia, String telefon, String email, String miasto,String poczta, String ulica, String mieszkanie) {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
        this.telefon=telefon;
        this.miasto=miasto;
        this.poczta=poczta;
        this.ulica=ulica;
        this.mieszkanie=mieszkanie;
        zamowienia = new HashSet<Zamowienie>();
    }

    public Osoba(String imie, String nazwisko, String data_urodzenia, String telefon, String email, String miasto, String ulica, String mieszkanie, String login, String haslo, String typ) {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
        this.telefon=telefon;
        this.miasto=miasto;
        this.ulica=ulica;
        this.mieszkanie=mieszkanie;
        this.login=login;
        this.haslo=haslo;
        this.typ=typ;
        zamowienia = new HashSet<Zamowienie>();
    }

    @Override
    public String toString() {
        return String.format(imie +" "+ nazwisko +" ["+telefon+"] "+ulica+" "+mieszkanie);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {        return imie;    }
    public void setImie(String imie) {        this.imie = imie;    }

    public String getNazwisko() {        return nazwisko;    }
    public void setNazwisko(String nazwisko) {        this.nazwisko = nazwisko;    }

    public String getTelefon() {        return telefon;    }
    public void setTelefon(String telefon) {        this.telefon = telefon;    }

    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }

    public String getMiasto() {        return miasto;    }
    public void setMiasto(String miasto) {        this.miasto = miasto;    }

    public String getUlica() {        return ulica;    }
    public void setUlica(String ulica) {        this.ulica = ulica;    }

    public String getMieszkanie() {        return mieszkanie;    }
    public void setMieszkanie(String mieszkanie) {        this.mieszkanie = mieszkanie;    }

    public String getPoczta() {        return poczta;    }
    public void setPoczta(String poczta) {        this.poczta = poczta;    }

    public String getLogin() {        return login;    }
    public void setLogin(String login) {        this.login = login;    }

    public String getHaslo() {        return haslo;    }
    public void setHaslo(String haslo) {        this.haslo = haslo;    }

    public String getTyp() {        return typ;    }
    public void setTyp(String typ) {        this.typ = typ;    }

    public Set<Zamowienie> getZamowienia() {        return zamowienia;    }
    public void setZamowienia(Set<Zamowienie> zamowienia) {        this.zamowienia = zamowienia;    }
}

