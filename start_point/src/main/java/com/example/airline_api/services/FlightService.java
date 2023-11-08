package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
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

    //CREATE/POST - method to add a new flight:
    public Flight addNewFlight (Flight flight){
        return flightRepository.save(flight);
    }

    //READ/GET - method to display all available flights:
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    //READ/GET - method to display details of a specific flight
    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public Flight bookPassengerToFlight(BookingDTO bookingDTO, Long id){
        Flight flight = flightRepository.findById(id).get();  //flight that is equal to the flight found
        Passenger passenger = passengerRepository.findById(bookingDTO.getPassengerId()).get();
        flight.addPassenger(passenger);
        return flight;
    }

    //CREATE/POST -

}
