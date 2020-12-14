package com.chris.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.main.models.License;
import com.chris.main.repositories.LicenseRepo;

@Service
public class LicenseService {
	
	private final LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public List<License> allLicenses() {
		return licenseRepo.findAll();
	}
	
	private Integer count = 1;
	public License createLicense(License license) {
		license.setNumber(Integer.toString(count));
		count += 1;
		return licenseRepo.save(license);
	}
	
	public License updateLicense(License license) {
		return licenseRepo.save(license);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepo.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public void deleteLicense(License license) {
		licenseRepo.deleteById(license.getId());
	}
}

