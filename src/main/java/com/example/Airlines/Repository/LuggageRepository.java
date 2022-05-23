package com.example.Airlines.Repository;

import com.example.Airlines.Model.Flight;
import com.example.Airlines.Model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Integer> {

//    @Query("SELECT t FROM LUGGAGE t WHERE t.Flight_Id = 1")
//    List<Luggage> findByFlightId(int Flight_Id);

//    public List<Flight> findByFlightId(String flightId);


//    @Query("SELECT COUNT(DEPARTURE_AIRPORTIATACODE) FROM FLIGHTS WHERE DEPARTURE_AIRPORTIATACODE = :c")
//    public List<Luggage> getInformationByFlightNumber(@Param("c") String flightId);
}
