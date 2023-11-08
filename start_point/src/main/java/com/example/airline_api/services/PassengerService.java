package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {         //BUSINESS LOGIC CLASS to route methods:
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    //CREATE/POST - method to add a new passenger:
    public Passenger addPassenger (Passenger passenger){
        return passengerRepository.save(passenger);
    }

    //READ/GET - method to display specific passenger details:
    public Passenger findPassenger (Long id) {
        return passengerRepository.findById(id).get();
    }

    //READ/GET - method to display all passengers:
    public List<Passenger> getAllPassengers (Long id) {
        return passengerRepository.findAll();
    }




}
