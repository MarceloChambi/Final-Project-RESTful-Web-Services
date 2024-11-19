package com.finalexam.finalexamcurs000224.services;

import com.finalexam.finalexamcurs000224.model.Person;
import com.finalexam.finalexamcurs000224.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el ID: " + id));
    }

    @Override
    public Person update(Long id, Person updatePerson) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el ID: " + id));

        person.setFirstName(updatePerson.getFirstName());
        person.setLastName(updatePerson.getLastName());
        person.setAge(updatePerson.getAge());
        person.setEmail(updatePerson.getEmail());
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Persona no encontrada con el ID: " + id);
        }
        personRepository.deleteById(id);
    }
}
