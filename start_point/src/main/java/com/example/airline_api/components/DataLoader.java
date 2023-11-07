package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
// this class adds the data to the table; hence the name data loader.
@Component      //to load the information into the table.
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Display all available flights is in FlightService
        //Display details of a specific flight is in FlightService


   //CREATE/POST - method to add details of a new flight:

        //flight1:
        Flight flight1 = new Flight("Dublin, Ireland", 120, "10/12/2023", "06:00");
        flightRepository.save(flight1);
    //adding a passenger to a flight:
        Passenger passenger1 = new Passenger("Billie", "billie@bnta.com");
        passenger1.addFlight(flight1);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Ella", "ella@bnta.com");
        passenger2.addFlight(flight1);
        passengerRepository.save(passenger2);

        //flight 2:
        Flight flight2 = new Flight("Oslo, Norway", 200, "28/12/2023", "13:00");
        flightRepository.save(flight2);

        Passenger passenger3 = new Passenger("David", "david@bnta.com");
        passenger3.addFlight(flight2);
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Sophia", "sophia@bnta.com");
        passenger4.addFlight(flight2);
        passengerRepository.save(passenger4);

        //flight 3:
        Flight flight3 = new Flight("Barcelona, Spain", 250, "10/01/2024", "10:00");
        flightRepository.save(flight3);

        Passenger passenger5 = new Passenger("John", "john@bnta.com");
        passenger5.addFlight(flight3);
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Victoria", "victoria@bnta.com");
        passenger6.addFlight(flight3);
        passengerRepository.save(passenger6);



        //CREATE/POST - method to add a new passenger:




        //Display details of all passengers


        //Display details of a specific passenger


        //Book a passenger on to a flight


        //Cancel a flight

    }
}
