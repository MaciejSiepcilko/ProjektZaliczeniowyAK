package com.example.demo.inner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
class MyController {

    private CountryRepository repo;

    MyController(CountryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/count")
    ResultDto getResult() {
        long count = repo.count();
        return new ResultDto(count);
    }

    @GetMapping("/{countryCode}")
    Country getCountry(@PathVariable String countryCode) {
        String upperCasedCode = countryCode.toUpperCase();
        Optional<Country> dbResult = repo.findByCode(upperCasedCode);
        return dbResult.orElseThrow(InvalidCountryCodeException::new);
    }
}
