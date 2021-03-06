package ru.kpfu.itis.gafurova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.zaripov.model.User;
import ru.kpfu.itis.zaripov.service.UserService;
import ru.kpfu.itis.zaripov.service.SmsService;
import ru.kpfu.itis.zaripov.service.impl.SmsServiceImpl;
import ru.kpfu.itis.zaripov.util.forms.SignInForm;
import ru.kpfu.itis.zaripov.util.forms.SignUpForm;
import ru.kpfu.itis.zaripov.util.transformers.SignUpFormToUserTransformer;

import javax.validation.Valid;
import java.util.function.Function;

@Controller
public class AuthController {

    private final UserService userService;
    private final Function<SignUpForm, User> transformer;
    private final SmsService smsService;

    public AuthController(UserService userService) {
        this.userService = userService;
        this.transformer = new SignUpFormToUserTransformer();
        this.smsService = new SmsServiceImpl();
    }

    @RequestMapping("/sign_in")
    public String getSignIn(@RequestParam(value = "error", required = false) Boolean error,
                            Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("signInForm", new SignInForm());
        return "sign_in";
    }

    @RequestMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new SignUpForm());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") @Valid SignUpForm signUpForm,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign_up";
        }
        User user = transformer.apply(signUpForm);
        if (!userService.getAll().contains(user)) {
            userService.add(user);
            smsService.successRegistration(user);


            return "redirect:/home";
        }
        return "redirect:/home";
    }
}
