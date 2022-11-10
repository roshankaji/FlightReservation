package com.psa.flight_reservation_app.services;

import com.psa.flight_reservation_app.dto.ReservationRequest;
import com.psa.flight_reservation_app.entities.Reservation;

public interface ReservationService {
	/*to book flight for us
	1.Flight Details
	2.Passenger Details
	3.Create a reservation
	*/
	
	Reservation bookFlight(ReservationRequest request);

}
