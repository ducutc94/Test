package com.example.testcasemd4.repository;

import com.example.testcasemd4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
}
