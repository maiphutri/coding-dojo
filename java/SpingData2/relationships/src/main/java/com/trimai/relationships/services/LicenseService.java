package com.trimai.relationships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.relationships.models.License;
import com.trimai.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepo licenseRepo;
	
	public License createLicense(License license) {
		return licenseRepo.save(license);
	}
	
}
