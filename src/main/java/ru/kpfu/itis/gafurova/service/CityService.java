package ru.kpfu.itis.gafurova.service;

import ru.kpfu.itis.zaripov.model.City;

import java.util.List;

public interface CityService {

    void add(City city);

    City findOneById(Long id);

    City findOneByName(String name);

    List<City> getAll();

    void delete(Long id);
}
