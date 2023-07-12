package com.example.testcasemd4.service.iml;

import com.example.testcasemd4.model.City;
import com.example.testcasemd4.repository.ICityRepository;
import com.example.testcasemd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepository iCityRepository;
    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public Optional<City> findOne(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public City save(City city) {
        return iCityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.deleteById(id);

    }
}
