package com.example.demo.inner;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CountryLanguageId.class)
class CountryLanguage {

    @Id
    private String countryCode;

    @Id
    private String language;

    private boolean isOfficial;

    String getLanguage() {
        return language;
    }

    boolean isOfficial() {
        return isOfficial;
    }
}

class CountryLanguageId implements Serializable {

    private String countryCode;

    private String language;
}
