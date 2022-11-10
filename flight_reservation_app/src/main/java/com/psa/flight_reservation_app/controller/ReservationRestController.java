package com.psa.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.flight_reservation_app.dto.ReservationUpdateRequest;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.repository.ReservationRepository;

@RestController

public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepo;
	
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
	
	Optional<Reservation> findById = reservationRepo.findById(id);	
		return findById.get();
	}
	
	
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		long id = request.getId();
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		
		return reservationRepo.save(reservation);
	}
	
}
