package org.assignment_3_2_producer.services;

import java.util.List;

import org.assignment_3_2_common_classes.entity.DVD;
import org.assignment_3_2_producer.repository.DVDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DVDService {

	@Autowired
	DVDRepository dvdRepository;
	
	public void addDVD(String title, Integer year, Double price) {
		DVD dvdToAdd = new DVD(title, year, price);
		this.dvdRepository.save(dvdToAdd);
	}
	
	public List<DVD> getAllDVDs() {
		return this.dvdRepository.findAll();
	}
}
