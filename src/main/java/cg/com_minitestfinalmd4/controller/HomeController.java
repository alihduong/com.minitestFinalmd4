package cg.com_minitestfinalmd4.controller;

import cg.com_minitestfinalmd4.model.City;
import cg.com_minitestfinalmd4.model.Country;
import cg.com_minitestfinalmd4.service.impl.CityServiceImpl;
import cg.com_minitestfinalmd4.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping
    public ModelAndView showCities() {
        ModelAndView modelAndView = new ModelAndView("list");
        Iterable<City> cities = cityService.findAll();
        if (!cities.iterator().hasNext()) {
            modelAndView.addObject("message", "We don't have any city");
        }
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        Iterable<Country> countries = countryService.findAllCountry();
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView save(@Validated @ModelAttribute City city, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("message", "Create Fail !!!");
            return modelAndView;
        }
        City city1 = cityService.save(city);
        if (city1 != null) {
            modelAndView.addObject("message", "Create City Successfully !!!");
        }
        modelAndView.addObject("countries", countryService.findAllCountry());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        cityService.remove(id);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Optional<City> city = cityService.findOne(id);
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<City> city = cityService.findOne(id);
        Iterable<Country> countries = countryService.findAllCountry();
        modelAndView.addObject("countries", countries);
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id, @ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("edit");
        city.setId(id);
        City cityEdit = cityService.save(city);
        if (cityEdit != null) {
            modelAndView.addObject("countries", countryService.findAllCountry());
            modelAndView.addObject("message", "Update City Successfully");
        }
        return modelAndView;
    }

}
