package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    ZamowienieRepository zamowienieRepository;
    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    SkladnikRepository skladnikRepository;
    @Autowired
    OsobaRepository osobaRepository;

    @RequestMapping(value = "/print_zamowienia", method = RequestMethod.GET)
    public String print_zamowienie(Model model)
    {
        List<Zamowienie> zamowienieList =  zamowienieRepository.findAll();

        model.addAttribute("header","Lista wszystkich pizz"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("zamowienieList",zamowienieList); //Dodanie obiektu do pamieci lokalnej modelu


        return "print_zamowienia"; //Przekierowanie na strone
    }

    @RequestMapping(value = "/print_osoby", method = RequestMethod.GET)
    public String print_osoby(Model model)
    {
        List<Osoba> osobaList =  osobaRepository.findAll();

        model.addAttribute("header","Lista wszystkich pizz"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("osobaList",osobaList); //Dodanie obiektu do pamieci lokalnej modelu


        return "print_osoby"; //Przekierowanie na strone
    }

    @RequestMapping(value = "/print_pizza", method = RequestMethod.GET)
    public String print_pizza(Model model)
    {
        List<Pizza> pizzaList =  pizzaRepository.findAll();

        model.addAttribute("header","Lista wszystkich pizz"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("pizzaList",pizzaList); //Dodanie obiektu do pamieci lokalnej modelu


        return "print_pizza"; //Przekierowanie na strone
    }

    @RequestMapping(value = "/edit_pizza", method = RequestMethod.GET)
    public String edit_pizza(Model model)
    {
        List<Pizza> pizzaList =  pizzaRepository.findByNazwa("Kurczak");
        List<Skladnik> skladnikList =  skladnikRepository.findAll();

        model.addAttribute("header","Lista wszystkich pizz"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("pizzaList",pizzaList); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("skladnikList",skladnikList); //Dodanie obiektu do pamieci lokalnej modelu


        return "edit_pizza"; //Przekierowanie na strone
    }


    @RequestMapping(value = "/print_skladniki", method = RequestMethod.GET)
    public String print_skladniki(Model model)
    {
        List<Skladnik> skladnikList =  skladnikRepository.findAll();

        model.addAttribute("header","Lista wszystkich pizz"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("skladnikList",skladnikList); //Dodanie obiektu do pamieci lokalnej modelu

        return "print_skladniki"; //Przekierowanie na strone
    }


    //Obsluga bledow

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}

        