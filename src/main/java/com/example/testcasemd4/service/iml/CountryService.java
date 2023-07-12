package com.example.testcasemd4.service.iml;

import com.example.testcasemd4.model.Country;
import com.example.testcasemd4.repository.ICountryRepository;
import com.example.testcasemd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository iCountryRepository;
    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Optional<Country> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
