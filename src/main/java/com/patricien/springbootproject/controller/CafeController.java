package com.patricien.springbootproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.patricien.springbootproject.model.Cafe;
import com.patricien.springbootproject.service.CafeService;

@RestController
@RequestMapping("/api/cafe")
public class CafeController {
	
	private CafeService cafeService;

	public CafeController(CafeService cafeService) {
		super();
		this.cafeService = cafeService;
	}
	
	// build create cafe REST API
	@PostMapping()
	public ResponseEntity<Cafe> saveCafe(@RequestBody Cafe cafe){
		return new ResponseEntity<Cafe>(cafeService.saveCafe(cafe), HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Cafe> getAllCafe(){
		return cafeService.getAllCafe();
	}
	
	
	@GetMapping("{itemCode}")
	public ResponseEntity<Cafe> getCafeById(@PathVariable("itemCode") int itemCode){
		return new ResponseEntity<Cafe>(cafeService.getCafeById(itemCode), HttpStatus.OK);
	}
	
	
	@PutMapping("{itemCode}")
	public ResponseEntity<Cafe> updateCafe(@PathVariable("itemCode") int itemCode
												  ,@RequestBody Cafe cafe){
		return new ResponseEntity<Cafe>(cafeService.updateCafe(cafe, itemCode), HttpStatus.OK);
	}
	
	
	@DeleteMapping("{itemCode}")
	public ResponseEntity<String> deleteCafe(@PathVariable("itemCode") int itemCode){
		
		// delete employee from DB
		cafeService.deleteCafe(itemCode);
		
		return new ResponseEntity<String>("Cafe deleted successfully!.", HttpStatus.OK);
	}
	
}