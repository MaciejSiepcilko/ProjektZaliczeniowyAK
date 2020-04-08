package com.example.demo.inner;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface CountryRepository extends CrudRepository<Country, String> {


    Optional<Country> findByCode(String code);
}
