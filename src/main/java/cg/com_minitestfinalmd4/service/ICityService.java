package cg.com_minitestfinalmd4.service;

import cg.com_minitestfinalmd4.model.City;

import java.util.Optional;

public interface ICityService {
    Iterable<City> findAll();
    Optional<City> findOne(Long id);
    City save(City city);
    void remove(Long id);
}
