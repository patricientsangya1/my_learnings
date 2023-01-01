package com.patricien.springbootproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patricien.springbootproject.model.Cafe;
import com.patricien.springbootproject.repository.CafeRepository;

@SpringBootTest
class TestCafe22385 {
	
	@Autowired
	CafeRepository cafeRepo;
	// Test for creating a cafe item
	@Test
	public void testCreate() {
		
		Cafe cafe = new Cafe();
		cafe.setItemCode(3);
		cafe.setItemName("Caprio");
		cafe.setCategory("Cafe");
		cafe.setPrice(3000);
		cafeRepo.save(cafe);
		assertNotNull(cafeRepo.findById(3).get());
		
	}
	
	// Test for finding a cafe by cafe code
	@Test
	public void testSingleCafe() {
		Cafe cafe = cafeRepo.findById(1).get();
		assertEquals(1, cafe.getItemCode());
	}
	
	// Test for finding All cafe items
	@Test
	public void testReadAll() {
		List<Cafe> list = cafeRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	// test for updating a cafe item information
	@Test
	public void testUpdate() {
		Cafe emp = cafeRepo.findById(2).get();
		emp.setPrice(5000);
		cafeRepo.save(emp);
		assertNotEquals("jambo@gmail.com", cafeRepo.findById(2).get().getPrice());
	}
	
	// Test for deleting a cafe
	@Test
	public void testDelete() {
		cafeRepo.deleteById(3);
		assertThat(cafeRepo.existsById(3)).isFalse();
	}

}
