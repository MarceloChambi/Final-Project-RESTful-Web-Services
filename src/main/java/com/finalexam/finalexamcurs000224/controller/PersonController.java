package com.finalexam.finalexamcurs000224.controller;

import com.finalexam.finalexamcurs000224.model.Person;
import com.finalexam.finalexamcurs000224.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personService.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updateCategory(@PathVariable Long id, @RequestBody @Valid Person person) {
        return ResponseEntity.ok(personService.update(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
