package com.example.demo.inner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDto { // DTO czyli Data Transfer Object służy po prostu do przesyłania danych między systemami – same dane, żadnego zachowania

    private long count;

    private String notVisible; // nie ma gettera, więc nie będzie to widoczne

    public ResultDto(long count) {
        this.count = count;
    }

    public long getCount() { // JSON jest tworzony automatycznie z publicznych getterów
        return count;
    }

    String getSthInvisible() { // nie jest publiczny, więc nie będzie to widoczne
        return "sth";
    }

    @JsonProperty("json_name")
    // jak chemy inną nazwę niż ta automatycznie wygenerowana z nazwy gettera, z adnotacją nawet prywatny getter pójdzie do JSONa
    private String getSthWithCustomNameInJson() {
        return "sth2";
    }
}
