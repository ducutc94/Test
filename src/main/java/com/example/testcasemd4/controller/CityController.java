package com.example.testcasemd4.controller;

import com.example.testcasemd4.model.City;
import com.example.testcasemd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private ICityService iCityService;
    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        List<City> cityList = (List<City>) iCityService.findAll();
        if(cityList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(cityList,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> findOne(@PathVariable Long id){
        Optional<City> cityOptional = iCityService.findOne(id);
        if(cityOptional.isPresent()){
            return new ResponseEntity<>(cityOptional,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city){
        return new ResponseEntity<>(iCityService.save(city),HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id,@RequestBody City city){
        Optional<City> cityOptional = iCityService.findOne(id);
        if(cityOptional.isPresent()){
            city.setId(id);
            iCityService.save(city);
            return new ResponseEntity<>(city,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<City> cityOptional = iCityService.findOne(id);
        if(cityOptional.isPresent()){
            iCityService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
