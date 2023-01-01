package com.patricien.springbootproject.service;

import java.util.List;

import com.patricien.springbootproject.model.Cafe;

public interface CafeService {
	Cafe saveCafe(Cafe cafe);
	List<Cafe> getAllCafe();
	Cafe getCafeById(int itemCode);
	Cafe updateCafe(Cafe cafe, int itemCode);
	void deleteCafe(int itemCode);


}
