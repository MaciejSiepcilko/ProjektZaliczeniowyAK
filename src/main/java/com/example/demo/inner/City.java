package com.example.demo.inner;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class City {

    @Id
    private int id;

    private String name;

    private String countryCode;

    private String district;

    private int population;
}
