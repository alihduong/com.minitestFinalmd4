package cg.com_minitestfinalmd4.service;

import cg.com_minitestfinalmd4.model.Country;

import java.util.Optional;

public interface ICountryService {
    Iterable<Country> findAllCountry();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void deleteCountry(Long id);
}
