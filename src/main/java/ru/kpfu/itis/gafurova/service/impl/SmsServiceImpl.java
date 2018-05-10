package ru.kpfu.itis.gafurova.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.zaripov.model.User;
import ru.kpfu.itis.zaripov.service.SmsService;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class SmsServiceImpl implements SmsService {

    // @Value("${sms.aero.user}")
    private String smsAeroLogin = "rubingooddz@gmail.com";

    //@Value("${sms.aero.password}")
    private String smsAeroPassword = "GHDBImZtRrimymCd5Vh3gdtY56T";

    //@Value("${sms.aero.from}")
    private String smsAeroFrom = "SMS Aero";

    //@Value("${sms.aero.type}")
    private String smsAeroType = "7";

    //@Value("${sms.aero.url}")
    private String smsAeroUrl = "https://gate.smsaero.ru/send/";

    private RestTemplate restTemplate = new RestTemplate();

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void successRegistration(User user) {
        //Integer token = new Random().nextInt(9000) + 1000;

        String formattedNumber = user.getPhoneNumber().replace("+", "");

        Future<Boolean> result = executorService.submit(() -> {
            String text = "Поздравляем с регистрацией";
            String request = smsAeroUrl + "?user="
                    + smsAeroLogin + "&password="
                    + smsAeroPassword + "&to="
                    + formattedNumber
                    + "&text=" + text
                    + "&from="
                    + smsAeroFrom;
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(request, String.class);
            if (responseEntity.getBody().contains("accepted")) {
                return true;
            } else {
                throw new IllegalArgumentException("Проблемы с номером телефона");
            }
        });
        try {
            boolean isSuccessSend = result.get();
            System.out.println(isSuccessSend);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
