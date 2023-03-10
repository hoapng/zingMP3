package com.zingmp3.rest;

import com.zingmp3.entity.Category;
import com.zingmp3.entity.Country;
import com.zingmp3.repository.CategoryRepository;
import com.zingmp3.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryRest {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/public/country")
    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    @PostMapping("/admin/addCountry")
    public void addCountry(@RequestBody Country country){
        countryRepository.save(country);
    }

    @DeleteMapping("/admin/deleteCountry")
    public void deleteCountry(@RequestParam("id") Long id){
        countryRepository.deleteById(id);
    }
}
