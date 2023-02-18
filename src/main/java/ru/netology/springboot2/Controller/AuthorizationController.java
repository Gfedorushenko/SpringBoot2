package ru.netology.springboot2.Controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springboot2.Person.Person;
import ru.netology.springboot2.Repository.Authorities;
import ru.netology.springboot2.Service.AuthorizationService;

import java.util.*;

import static ru.netology.springboot2.Repository.Authorities.READ;


@RestController
public class AuthorizationController {
    private AuthorizationService service;
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Person user) {
        return service.getAuthorities(user);
    }
}