package cg.com_minitestfinalmd4.service.impl;

import cg.com_minitestfinalmd4.model.Country;
import cg.com_minitestfinalmd4.repository.ICountryRepository;
import cg.com_minitestfinalmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
