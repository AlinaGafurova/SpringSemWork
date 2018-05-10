package ru.kpfu.itis.gafurova.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.zaripov.model.User;


@Service
public interface SmsService {

    void successRegistration(User user);
}
