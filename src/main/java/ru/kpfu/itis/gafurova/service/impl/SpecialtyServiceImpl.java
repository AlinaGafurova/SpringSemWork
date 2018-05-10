package ru.kpfu.itis.gafurova.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.zaripov.model.Specialty;
import ru.kpfu.itis.zaripov.repository.SpecialtyRepository;
import ru.kpfu.itis.zaripov.service.SpecialtyService;

import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public void add(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public List<Specialty> findAllByCityId(Long city) {
        return specialtyRepository.findAllByCityId(city);
    }

    @Override
    public Specialty findOneByNameAndCityId(String name, Long cityId) {
        return specialtyRepository.findOneByNameAndCityId(name, cityId);
    }

    @Override
    public Specialty findOneById(Long specialtyId) {
        return specialtyRepository.findOne(specialtyId);
    }

    @Override
    public void delete(Long id) {
        specialtyRepository.delete(id);
    }
}
