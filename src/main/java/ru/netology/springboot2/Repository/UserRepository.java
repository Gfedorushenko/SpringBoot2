package ru.netology.springboot2.Repository;
import org.springframework.stereotype.Repository;
import ru.netology.springboot2.Person.Person;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.springboot2.Repository.Authorities.*;

public class UserRepository {
    private final ConcurrentHashMap<String, Person> requests = new ConcurrentHashMap<>();
    public UserRepository() {
        List<Authorities> theRights= new ArrayList<>();
        theRights.add(READ);
        theRights.add(WRITE);
        addPerson("Ivan", "123", theRights);
    }
    private void addPerson(String user, String password, List<Authorities> theRights){
        requests.put(user,new Person(user, password, theRights));
    }

    public List<Authorities> getUserAuthorities(Person person) {
        if(requests.containsKey(person.getUser()))
            if(requests.get(person.getUser()).passIsTrue(person.getPassword()))
                return requests.get(person.getUser()).getTheRights();

        return null;
    }
}