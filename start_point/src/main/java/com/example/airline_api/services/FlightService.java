package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    //READ/GET - method to display all available flights:
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    //READ/GET - method to display details of a specific flight
    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    //CREATE/POST -

}
