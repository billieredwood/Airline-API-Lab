package com.example.airline_api.controllers;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;


    // Display all available flights - READ/GET:
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightRepository.findAll(), HttpStatus.OK);
    }

    // Display a specific flight - READ/GET:
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Flight flight = flightService.findFlight(id);
        if (flight != null) {
        return new ResponseEntity<>(flight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add details of a new flight - CREATE/POST:
    @PostMapping
    public ResponseEntity<List<Flight>> addNewFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity<>(flightRepository.findAll(), HttpStatus.CREATED);
    }

    // Book passenger on a flight - modify/update:
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> bookPassengerToFlight(@RequestBody BookingDTO bookingDTO, @PathVariable Long id){
        return new ResponseEntity<>(flightService.bookPassengerToFlight(bookingDTO, id), HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
       flightService.cancelFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
