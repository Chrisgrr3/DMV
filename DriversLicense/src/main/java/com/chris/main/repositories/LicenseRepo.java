package com.chris.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chris.main.models.License;

public interface LicenseRepo extends CrudRepository<License, Long> {

	List<License> findAll();
}
