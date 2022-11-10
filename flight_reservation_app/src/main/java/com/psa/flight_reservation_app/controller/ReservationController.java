package com.psa.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.flight_reservation_app.dto.ReservationRequest;
import com.psa.flight_reservation_app.entities.Flight;
import com.psa.flight_reservation_app.entities.Reservation;
import com.psa.flight_reservation_app.repository.FlightRepository;
import com.psa.flight_reservation_app.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long id, ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(id);
		Flight flight = findById.get();
		modelMap.addAttribute("flight",flight);
		return "completeReservation";
	}
	
	@RequestMapping("/confirmRegistration")
	public String confirmRegistration(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Your booking is confirmed. Your booking id is "+reservation.getId());
		
		return "bookingConfirmation";
	}
}
