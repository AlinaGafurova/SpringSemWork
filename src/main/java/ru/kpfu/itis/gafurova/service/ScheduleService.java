package ru.kpfu.itis.gafurova.service;

import ru.kpfu.itis.zaripov.model.Schedule;

import java.util.List;

public interface ScheduleService {

    void add(Schedule schedule);

    Schedule findOneById(Long id);

    List<Schedule> getAll();

    Schedule findOneByTeacherId(Long teacherId);

    void deleteByTeacherId(Long teacherId);
}
