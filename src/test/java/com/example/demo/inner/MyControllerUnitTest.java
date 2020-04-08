package com.example.demo.inner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MyControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryRepository repository;

    @Test
    @DisplayName("should return proper error message when country code is not found")
    void handleCountryCodeNotFound() throws Exception {
        // given
        Mockito
                .when(repository.findByCode("XD"))
                .thenReturn(Optional.empty());
        mockMvc
                // when
                .perform(get("/api/XD"))
                //then
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{\"message\":\"INVALID_COUNTRY_CODE\"}"));
    }

    @Test
    void handleDatabaseDown() throws Exception {
        // given
        Mockito
                .when(repository.findByCode("BHR"))
                .thenThrow(new DataAccessResourceFailureException("bla bla bla"));
        mockMvc
                // when
                .perform(get("/api/BHR"))
                //then
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{\"message\":\"INTERNAL_ERROR\"}"));
    }

    @Test
    void shouldFindCountry() throws Exception {
        // given
        Mockito
                .when(repository.findByCode("BHR"))
                .thenReturn(Optional.of(new Country("", "", "", 3L, 1.3, new ArrayList<>())));

        mockMvc
                // when
                .perform(get("/api/BHR"))
                //then
                .andExpect(status().isOk());
    }
}
