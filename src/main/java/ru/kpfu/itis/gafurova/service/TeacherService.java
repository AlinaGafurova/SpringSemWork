package ru.kpfu.itis.gafurova.service;

import ru.kpfu.itis.zaripov.model.Teacher;

import java.util.List;

public interface TeacherService {

    void add(Teacher teacher);

    List<Teacher> findAllByStudioIdAndSpecialtyNameAndCityId(Long studioId, String specialty, Long cityId);

    Teacher findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(Long studioId, String specialty, Long cityId, String lastName);

    List<Teacher> getAll();

    Teacher findOneById(Long id);

    void delete(Long id);
}
