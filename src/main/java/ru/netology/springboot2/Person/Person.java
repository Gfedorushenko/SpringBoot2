package ru.netology.springboot2.Person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.netology.springboot2.Repository.Authorities;

import java.util.List;

public class Person {
    @NotBlank
    private String user;

    @NotBlank
    @Size(min = 3, max=15)
    private String password;
    private List<Authorities> theRights;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Person(String user, String password, List<Authorities> theRights) {
        this.user = user;
        this.password = password;
        this.theRights = theRights;
    }

    public List<Authorities> getTheRights() {
        return theRights;
    }

    public boolean passIsTrue(String password) {
        return password.equals(this.password);
    }
}