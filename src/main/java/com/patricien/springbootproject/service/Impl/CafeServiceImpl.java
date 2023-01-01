package com.patricien.springbootproject.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patricien.springbootproject.exception.ResourceNotFoundException;
import com.patricien.springbootproject.model.Cafe;
import com.patricien.springbootproject.repository.CafeRepository;
import com.patricien.springbootproject.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService{

	private CafeRepository cafeRepository;
	
	public CafeServiceImpl(CafeRepository employeeRepository) {
		super();
		this.cafeRepository = employeeRepository;
	}

	@Override
	public Cafe saveCafe(Cafe cafe) {
		return cafeRepository.save(cafe);
	}

	@Override
	public List<Cafe> getAllCafe() {
		return cafeRepository.findAll();
	}
	
	@Override
	public Cafe getCafeById(int itemCode) {
		Optional<Cafe> employee = cafeRepository.findById(itemCode);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", itemCode);
		}
//		return employeeRepository.findById(id).orElseThrow(() -> 
//						new ResourceNotFoundException("Employee", "Id", id));
//		
	}

	
	public Cafe updateCafe(Cafe cafe, int itemCode) {
		
		// we need to check whether employee with given id is exist in DB or not
		Cafe existingCafe = cafeRepository.findById(itemCode).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", itemCode)); 
		existingCafe.setItemName(cafe.getItemName());
		existingCafe.setCategory(cafe.getCategory());
		existingCafe.setPrice(cafe.getPrice());
		
		
		// save existing employee to DB
		cafeRepository.save(existingCafe);
		return existingCafe;
	}

	//@Override
	public void deleteCafe(int itemCode) {
		
		// check whether a employee exist in a DB or not
		cafeRepository.findById(itemCode).orElseThrow(() -> 
								new ResourceNotFoundException("Cafe", "Id", itemCode));
		cafeRepository.deleteById(itemCode);
	}

	
}
