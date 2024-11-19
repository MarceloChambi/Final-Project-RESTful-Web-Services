package com.finalexam.finalexamcurs000224.services;

import com.finalexam.finalexamcurs000224.model.Person;

public interface PersonService {
    Person save(Person person);

    Person findById(Long id);

    Person update(Long id, Person person);

    void delete(Long id);
}
