package ru.kpfu.itis.gafurova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.zaripov.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findOneById(Long id);

    City findOneByName(String name);
}
