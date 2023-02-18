package ru.netology.springboot2.Service;

import ru.netology.springboot2.Exception.*;
import ru.netology.springboot2.Person.Person;
import ru.netology.springboot2.Repository.*;
import java.util.*;

public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(Person person) {
        if (isEmpty(person.getUser()) || isEmpty(person.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(person);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + person.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}