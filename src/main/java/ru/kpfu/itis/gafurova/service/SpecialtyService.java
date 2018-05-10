package ru.kpfu.itis.gafurova.service;

import ru.kpfu.itis.zaripov.model.Specialty;

import java.util.List;

public interface SpecialtyService {

    void add(Specialty specialty);

    List<Specialty> getAll();

    List<Specialty> findAllByCityId(Long city);

    Specialty findOneByNameAndCityId(String name, Long cityId);

    Specialty findOneById(Long specialtyId);

    void delete(Long id);
}
