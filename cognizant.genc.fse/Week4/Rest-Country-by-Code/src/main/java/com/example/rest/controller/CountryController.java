package com.example.rest.controller;

import com.example.rest.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static Map<String, Country> countryMap = new HashMap<>();

    // Pre-load country data (could come from DB later)
    static {
        countryMap.put("in", new Country("in", "India", "New Delhi"));
        countryMap.put("us", new Country("us", "United States", "Washington, D.C."));
        countryMap.put("jp", new Country("jp", "Japan", "Tokyo"));
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        Country country = countryMap.get(code.toLowerCase());
        if (country == null) {
            throw new RuntimeException("Country code not found: " + code);
        }
        return country;
    }
}
