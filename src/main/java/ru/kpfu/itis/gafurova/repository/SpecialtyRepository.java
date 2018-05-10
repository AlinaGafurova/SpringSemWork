package ru.kpfu.itis.gafurova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.zaripov.model.Specialty;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    List<Specialty> findAllByCityId(Long cityId);

    Specialty findOneByNameAndCityId(String name, Long cityId);
}
