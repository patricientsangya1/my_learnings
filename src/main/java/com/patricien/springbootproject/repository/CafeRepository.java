package com.patricien.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patricien.springbootproject.model.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{

}
