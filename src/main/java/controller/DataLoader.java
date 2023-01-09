package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


//Dodanie osob do repozytorium na samym poczatku
@Component
public class DataLoader implements ApplicationRunner {

    private PizzaRepository pizzaRepository;

    private OsobaRepository osobaRepository;
    private SkladnikRepository skladnikRepository;
    private ZamowienieRepository zamowienieRepository;

    @Autowired
    public DataLoader(PizzaRepository pizzaRepository, SkladnikRepository skladnikRepository, ZamowienieRepository zamowienieRepository, OsobaRepository osobaRepository) {
        this.pizzaRepository = pizzaRepository;
        this.skladnikRepository = skladnikRepository;
        this.zamowienieRepository = zamowienieRepository;
        this.osobaRepository = osobaRepository;
    }

    public void run(ApplicationArguments args) {

        Osoba o1 = new Osoba("Piotr","Kowalski","08.02.2003","754954356","pkowal@wp.pl","Krosno","38-400","Lwowska","48");
        Osoba o2 = new Osoba("Adrian","Nowacki","24.08.1997","984356124","anowa@wp.pl","Krosno","38-400","Legionów","8/13");

        osobaRepository.save(o1);
        osobaRepository.save(o2);

        Zamowienie single = new Zamowienie("04.01.2023 15:45", 19.00, false);
        Zamowienie single1 = new Zamowienie("30.12.2022 20:11", 19.00, false);
        Zamowienie duo = new Zamowienie("04.01.2023 17:37", 36.00, false);

        zamowienieRepository.save(single);
        zamowienieRepository.save(single1);
        zamowienieRepository.save(duo);

        Pizza p_margeritta = new Pizza("Margeritta", 17.00);
        Pizza p_kurczak = new Pizza("Kurczak", 19.00);
        Pizza p_classic = new Pizza("Classic", 19.00);

        pizzaRepository.save(p_margeritta);
        pizzaRepository.save(p_kurczak);
        pizzaRepository.save(p_classic);

        Skladnik sos_pomidorowy = new Skladnik("sos pomidorowy");
        Skladnik ser_mozzarella = new Skladnik("ser mozzarella");
        Skladnik oregano = new Skladnik("oregano");
        Skladnik kurczak = new Skladnik("kurczak");
        Skladnik pieczarki = new Skladnik("pieczarki");
        Skladnik oliwki = new Skladnik("oliwki");
        Skladnik kukurydza = new Skladnik("kukurydza");
        Skladnik szynka = new Skladnik("szynka");
        Skladnik papryka = new Skladnik("papryka");

        skladnikRepository.save(sos_pomidorowy);
        skladnikRepository.save(ser_mozzarella);
        skladnikRepository.save(oregano);
        skladnikRepository.save(kurczak);
        skladnikRepository.save(pieczarki);
        skladnikRepository.save(oliwki);
        skladnikRepository.save(kukurydza);
        skladnikRepository.save(szynka);
        skladnikRepository.save(papryka);

        ///-------------------------------------------------------
        single.getPizzas().add(p_kurczak);
        p_kurczak.getZamowienia().add(single);

        single1.getPizzas().add(p_classic);
        p_classic.getZamowienia().add(single1);

        duo.getPizzas().add(p_margeritta);
        duo.getPizzas().add(p_kurczak);
        p_margeritta.getZamowienia().add(duo);
        p_kurczak.getZamowienia().add(duo);
        ///----------------------------------------------------
        o1.getZamowienia().add(single);
        single.setOsoba(o1);

        o1.getZamowienia().add(single1);
        single1.setOsoba(o1);

        o2.getZamowienia().add(duo);
        duo.setOsoba(o2);
        ///----------------------------------------------------
        p_margeritta.getSkladniki().add(sos_pomidorowy);
        p_margeritta.getSkladniki().add(ser_mozzarella);
        p_margeritta.getSkladniki().add(oregano);

        p_classic.getSkladniki().add(sos_pomidorowy);
        p_classic.getSkladniki().add(ser_mozzarella);
        p_classic.getSkladniki().add(oregano);
        p_classic.getSkladniki().add(szynka);
        p_classic.getSkladniki().add(papryka);
        p_classic.getSkladniki().add(pieczarki);

        p_kurczak.getSkladniki().add(sos_pomidorowy);
        p_kurczak.getSkladniki().add(ser_mozzarella);
        p_kurczak.getSkladniki().add(oregano);
        p_kurczak.getSkladniki().add(kurczak);
        p_kurczak.getSkladniki().add(pieczarki);
        p_kurczak.getSkladniki().add(oliwki);
        p_kurczak.getSkladniki().add(kukurydza);

        sos_pomidorowy.getPizzas().add(p_margeritta);
        sos_pomidorowy.getPizzas().add(p_classic);
        sos_pomidorowy.getPizzas().add(p_kurczak);

        ser_mozzarella.getPizzas().add(p_margeritta);
        ser_mozzarella.getPizzas().add(p_classic);
        ser_mozzarella.getPizzas().add(p_kurczak);

        oregano.getPizzas().add(p_margeritta);
        oregano.getPizzas().add(p_classic);
        oregano.getPizzas().add(p_kurczak);

        kurczak.getPizzas().add(p_kurczak);

        pieczarki.getPizzas().add(p_classic);
        pieczarki.getPizzas().add(p_kurczak);

        oliwki.getPizzas().add(p_kurczak);

        kukurydza.getPizzas().add(p_kurczak);

        szynka.getPizzas().add(p_classic);

        papryka.getPizzas().add(p_classic);

        osobaRepository.save(o1);
        osobaRepository.save(o2);

        zamowienieRepository.save(single);
        zamowienieRepository.save(single1);
        zamowienieRepository.save(duo);

        pizzaRepository.save(p_margeritta);
        pizzaRepository.save(p_kurczak);
        pizzaRepository.save(p_classic);

        skladnikRepository.save(sos_pomidorowy);
        skladnikRepository.save(ser_mozzarella);
        skladnikRepository.save(oregano);
        skladnikRepository.save(kurczak);
        skladnikRepository.save(pieczarki);
        skladnikRepository.save(oliwki);
        skladnikRepository.save(kukurydza);
        skladnikRepository.save(szynka);
        skladnikRepository.save(papryka);

    }
}