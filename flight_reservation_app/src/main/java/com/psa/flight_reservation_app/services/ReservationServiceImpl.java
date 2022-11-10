package com.psa.flight_reservation_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.flight_reservation_app.dto.ReservationRequest;
import com.psa.flight_reservation_app.entities.Flight;
import com.psa.flight_reservation_app.entities.Passenger;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.repository.FlightRepository;
import com.psa.flight_reservation_app.repository.PassengerRepository;
import com.psa.flight_reservation_app.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPassengerMobile());
		passengerRepo.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setCheckedIn(false);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		Reservation save = reservationRepo.save(reservation);
		
		
		
		return save;
	}

}
