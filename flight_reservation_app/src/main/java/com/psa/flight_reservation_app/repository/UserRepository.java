package com.psa.flight_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flight_reservation_app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{


	User findByEmail(String emailid);

}
