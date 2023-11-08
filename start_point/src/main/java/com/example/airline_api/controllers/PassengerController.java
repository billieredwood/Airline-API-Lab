package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

    // READ - Display details of all passengers:
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerRepository.findAll(), HttpStatus.OK);
    }       //searchable in postman by passengers: confirmed.

    // READ - Display specific passenger details:
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.findPassenger(id);
        if (passenger != null) {
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }       //searchable in postman by passengers/'id': confirmed.
    }
    // CREATE - Add a new passenger:
    @PostMapping
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger) {
        Passenger newPassenger = passengerService.addPassenger(passenger);
        return new ResponseEntity<>(newPassenger, HttpStatus.CREATED);
    }       //functional in postman via a GET request using passengers. passengers added and assigned to specific flights too: confirmed.







}
