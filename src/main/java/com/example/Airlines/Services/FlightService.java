package com.example.Airlines.Services;

import com.example.Airlines.Model.Flight;
import com.example.Airlines.Model.Luggage;
import com.example.Airlines.Repository.FlightRepository;
import com.example.Airlines.Repository.LuggageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    LuggageRepository luggageRepository;

    public List<Flight> findAllFlights(){
        return (List<Flight>) flightRepository.findAll();
    }

    public List<Luggage> findAllLuggage(){
        return (List<Luggage>) luggageRepository.findAll();
    }

    public void deleteAllFlights(){
        flightRepository.deleteAll();
    }

    public void deleteAllLuggage(){
        luggageRepository.deleteAll();
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public Luggage addLuggage(Luggage luggage){
        return luggageRepository.save(luggage);
    }

//    public List<Luggage> infoByFlightNumber(int id){
//        return (List<Luggage>) luggageRepository.findByFlightId(id);
//    }

    public void informationByFlightNumber(){
        //cargo weight SELECT SUM(LUGGAGE.WEIGHT) FROM LUGGAGE WHERE FLIGHT_ID = 0 AND LUGGAGE_TYPE = 'cargo';
        //baggage weight SELECT SUM(LUGGAGE.WEIGHT) FROM LUGGAGE WHERE FLIGHT_ID = 0 AND LUGGAGE_TYPE = 'baggage';
        // total weight SELECT SUM(LUGGAGE.WEIGHT) FROM LUGGAGE WHERE FLIGHT_ID = 0;
        return;
    }

    public void informationByIATA(){
        //number of flights departing from this SELECT COUNT(DEPARTURE_AIRPORTIATACODE) FROM FLIGHTS WHERE DEPARTURE_AIRPORTIATACODE = 'GDN';
        //number of flights arriving to this SELECT COUNT(ARRIVAL_AIRPORTIATACODE ) FROM FLIGHTS WHERE ARRIVAL_AIRPORTIATACODE  = 'SEA';
        //total number of pieces of baggage arriving to this airport SELECT SUM(LUGGAGE.PIECES), FLIGHTS.ARRIVAL_AIRPORTIATACODE  FROM LUGGAGE JOIN FLIGHTS ON FLIGHTS.FLIGHT_ID = LUGGAGE.FLIGHT_ID WHERE FLIGHTS.ARRIVAL_AIRPORTIATACODE  = 'SEA';
        //total number of pieces of baggage departing from this airport SELECT SUM(LUGGAGE.PIECES), FLIGHTS.DEPARTURE_AIRPORTIATACODE  FROM LUGGAGE JOIN FLIGHTS ON FLIGHTS.FLIGHT_ID = LUGGAGE.FLIGHT_ID WHERE FLIGHTS.DEPARTURE_AIRPORTIATACODE = 'GDN';

        return;
    }

}
