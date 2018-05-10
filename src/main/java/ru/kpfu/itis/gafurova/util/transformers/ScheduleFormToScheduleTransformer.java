package ru.kpfu.itis.gafurova.util.transformers;

import ru.kpfu.itis.zaripov.model.Schedule;
import ru.kpfu.itis.zaripov.util.forms.ScheduleForm;

import java.util.function.Function;

public class ScheduleFormToScheduleTransformer implements Function<ScheduleForm, Schedule> {
    @Override
    public Schedule apply(ScheduleForm scheduleForm) {
        Schedule schedule = new Schedule();
        schedule.setMonday(scheduleForm.getMonday());
        schedule.setTuesday(scheduleForm.getTuesday());
        schedule.setWednesday(scheduleForm.getWednesday());
        schedule.setThursday(scheduleForm.getThursday());
        schedule.setFriday(scheduleForm.getFriday());
        schedule.setSaturday(scheduleForm.getSaturday());
        schedule.setSunday(scheduleForm.getSunday());
        return schedule;
    }
}
