package com.keyin.sprintOneFinalTerm;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.keyin.sprintOneFinalTerm.controller.AircraftController;
import com.keyin.sprintOneFinalTerm.controller.PassengerController;
import com.keyin.sprintOneFinalTerm.controller.CityController;
import com.keyin.sprintOneFinalTerm.service.PassengerService;
import com.keyin.sprintOneFinalTerm.service.AircraftService;
import com.keyin.sprintOneFinalTerm.service.CityService;
import com.keyin.sprintOneFinalTerm.model.City;
import com.keyin.sprintOneFinalTerm.model.Passenger;
import com.keyin.sprintOneFinalTerm.model.Airport;


import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class SprintOneFinalTermApplicationTests {
    @Mock
    private AircraftController aircraftController;

    @Mock
    private AirportController airportController;

    @Mock
    private CityController cityController;

    @Mock
    private PassengerController passengerController;

    @InjectMocks
    private AircraftService aircraftService;

    @InjectMocks
    private AirportService airportService;

    @InjectMocks
    private CityService cityService;

    @InjectMocks
    private PassengerService passengerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAirport() {
        Airport airport = new Airport(1, "St John's Airport");
        when(airportController.findById(1)).thenReturn(Optional.of(airport));

        Airport result = airportService.getAirportById(1);
        assertNotNull(result);
        assertEquals("St John's Airport", result.getName());
    }

    @Test
    public void testGetCity() {
        City city = new City(1, "St John's");
        when(cityController.findById(1)).thenReturn(Optional.of(city));

        City result = cityService.getCityById(1);
        assertNotNull(result);
        assertEquals("St John's", result.getName());
    }

    @Test
    public void testGetPassenger() {
        Passenger passenger = new Passenger(1, "John Doe");
        when(passengerController.findById(1)).thenReturn(Optional.of(passenger));

        Passenger result = passengerService.getPassengerById(1);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

}
