package com.psa.flight_reservation_app.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psa.flight_reservation_app.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(String departureCity, String arrivalCity, Date dateOfDeparture);

}
