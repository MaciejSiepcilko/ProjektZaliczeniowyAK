package com.example.demo.inner;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
class Country {

    @Id
    private String code;

    private String name;

    private String continent;

    private Long population;

    private Double lifeExpectancy;

    public Country() {
    }

    public Country(String code, String name, String continent, Long population, Double lifeExpectancy, List<CountryLanguage> countryLanguages) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.countryLanguages = countryLanguages;
    }

    @OneToMany(mappedBy = "countryCode", fetch = FetchType.EAGER)
    private List<CountryLanguage> countryLanguages;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public Long getPopulation() {
        return population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    @JsonProperty("country_language")
    public List<String> getCountryOfficialLanguage() {
        return countryLanguages.stream()
                .filter(CountryLanguage::isOfficial)
                .map(CountryLanguage::getLanguage)
                .collect(Collectors.toList());
    }
}
