package ru.kpfu.itis.gafurova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.zaripov.model.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAllByStudioIdAndSpecialtyNameAndCityId(Long studioId, String specialtyName, Long cityId);

    Teacher findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(Long studioId, String specialtyName, Long cityId, String lastName);

}
