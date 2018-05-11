package com.umanav.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.license.models.License;

import com.umanav.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
    public LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }
	public void addLicense(License license) {
		licenseRepository.save(license);
	}
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	public License byID(Long id) {
		Optional<License> license = licenseRepository.findByperson_id(id);
		return license.get();
	}
	public License lastID() {
		Optional<License> license = licenseRepository.findFirstByOrderByIdDesc();
		return license.get();
	}
}
