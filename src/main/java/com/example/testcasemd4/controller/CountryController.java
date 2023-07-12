package com.example.testcasemd4.controller;

import com.example.testcasemd4.model.Country;
import com.example.testcasemd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private ICountryService iCountryService;
    @GetMapping
    public ResponseEntity<Iterable<Country>> findAll(){
        List<Country> countryList = (List<Country>) iCountryService.findAll();
        if(countryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(countryList,HttpStatus.OK);
        }
    }
}
