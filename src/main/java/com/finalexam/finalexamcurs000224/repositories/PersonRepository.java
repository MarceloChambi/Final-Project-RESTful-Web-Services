package com.finalexam.finalexamcurs000224.repositories;

import com.finalexam.finalexamcurs000224.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}