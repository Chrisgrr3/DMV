package com.chris.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chris.main.models.Person;

public interface PersonRepo extends CrudRepository<Person, Long> {

	List<Person> findAll();
}
