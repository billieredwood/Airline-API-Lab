package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Add details of a new flight
        Flight flight1 = new Flight("Dublin, Ireland", 120, "10/12/2023", "06:00");
        flightRepository.save(flight1);

        //Display all available flights



        //Display details of a specific flight


        //Add a new passenger


        //Display details of all passengers


        //Display details of a specific passenger


        //Book a passenger on to a flight


        //Cancel a flight

    }
}
