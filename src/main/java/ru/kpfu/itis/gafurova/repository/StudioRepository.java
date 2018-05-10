package ru.kpfu.itis.gafurova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.zaripov.model.Studio;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

    List<Studio> findAllByCityId(Long cityId);

    Studio findOneByNameAndCityId(String name, Long cityId);
}
