package com.hexaware.simplyfly.services;

import java.util.ArrayList;

/**
 * Service for managing bookings.
 * Handles booking creation, update, deletion, and retrieval.
 * Author: Vikashini
 * Version: 1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.dto.BookingDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.entities.Flight;
import com.hexaware.simplyfly.enums.BookingStatus;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.RouteNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.repositories.BookingRepository;
import com.hexaware.simplyfly.repositories.FlightRepository;
import com.hexaware.simplyfly.repositories.RouteRepository;
import com.hexaware.simplyfly.repositories.UserRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private FlightRepository flightRepository;

//	@Override
//	public Booking createBooking(BookingDTO dto) throws UserNotFoundException, RouteNotFoundException {
//
////		User user = userRepository.findById(dto.getUser_id())
////				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + dto.getUser_id()));
////
////		Route route = routeRepository.findById(dto.getRoute_id())
////				.orElseThrow(() -> new RouteNotFoundException("Route not found with ID: " + dto.getRoute_id()));
//
//		Booking booking = new Booking();
//		booking.setBookedAt(dto.getBookedAt());
//		booking.setStatus(dto.getStatus()); // Now uses shared enum directly
//		booking.setTotalFare(dto.getTotalFare());
//		booking.setUsername(dto.getUsername());
//		booking.setOrigin(dto.getOrigin());
//		booking.setDestination(dto.getDestination());
//		booking.setBookDate(dto.getBookDate());
//		
////		booking.setUser(user);
////		booking.setRoute(route);
//
//		return bookingRepository.save(booking);
//	}
	

	@Override
	public Booking createBooking(BookingDTO dto) throws UserNotFoundException, RouteNotFoundException {
	    Booking booking = new Booking();
	    booking.setBookedAt(dto.getBookedAt());
	    booking.setStatus(dto.getStatus());
	    booking.setTotalFare(dto.getTotalFare());
	    booking.setUsername(dto.getUsername());
	    booking.setOrigin(dto.getOrigin());
	    booking.setDestination(dto.getDestination());
	    booking.setBookDate(dto.getBookDate());

	    if (dto.getFlightCode() != null) {
	        Flight flight = flightRepository.findByFlightCode(dto.getFlightCode())
	            .orElseThrow(() -> new RuntimeException("Flight not found with code: " + dto.getFlightCode()));
	        booking.setFlight(flight);
	    }

	    return bookingRepository.save(booking);
	}


//	public Booking createBooking(BookingHelperDTO dto) throws UserNotFoundException, RouteNotFoundException{
//		User user = userRepository.findByUsername(dto.getUsername())
//			.orElseThrow(() -> new UserNotFoundException("User not found"));
//
//		Route route = routeRepository.findByOriginAndDestination(dto.getOrigin(), dto.getDestination())
//			.orElseThrow(() -> new RouteNotFoundException("Route not found"));
//
//		Booking booking = new Booking();
//		booking.setBookedAt(LocalDateTime.now());
//		booking.setStatus(dto.getStatus());
//		booking.setUser(user);
//		booking.setRoute(route);
//
//		booking.setTotalFare(route.getBaseFare());
//
//		return bookingRepository.save(booking);
//	}

	@Override
	public Booking updateBooking(Long booking_id, BookingDTO dto)
			throws BookingNotFoundException, UserNotFoundException, RouteNotFoundException {
		Booking booking = bookingRepository.findById(booking_id)
				.orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + booking_id));
		/*
		 * User user = userRepository.findById(dto.getUser_id()) .orElseThrow(() -> new
		 * UserNotFoundException("User not found with ID: " + dto.getUser_id()));
		 * 
		 * Route route = routeRepository.findById(dto.getRoute_id()) .orElseThrow(() ->
		 * new RouteNotFoundException("Route not found with ID: " + dto.getRoute_id()));
		 */

		booking.setBookedAt(dto.getBookedAt());
		booking.setStatus(dto.getStatus()); // Shared enum
		booking.setTotalFare(dto.getTotalFare());/*
													 * booking.setUser(user); booking.setRoute(route);
													 */
		booking.setUsername(dto.getUsername());
		booking.setOrigin(dto.getOrigin());
		booking.setDestination(dto.getDestination());
		booking.setBookDate(dto.getBookDate());
		return bookingRepository.save(booking);
	}

	@Override
	public boolean deleteBooking(Long booking_id) throws BookingNotFoundException {
		if (!bookingRepository.existsById(booking_id)) {
			throw new BookingNotFoundException("Booking not found with ID: " + booking_id);
		}
		bookingRepository.deleteById(booking_id);
		return true;
	}

	@Override
	public Booking getBookingById(Long booking_id) throws BookingNotFoundException {
		return bookingRepository.findById(booking_id)
				.orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + booking_id));
	}

//	@Override
//	public List<Booking> getAllBookings() {
//		return bookingRepository.findAll();
//	}
//	
	
	@Override
	public List<BookingDTO> getAllBookings() {
	    List<Booking> bookings = bookingRepository.findAll();
	    List<BookingDTO> dtoList = new ArrayList<>();

	    for (Booking b : bookings) {
	        BookingDTO dto = new BookingDTO();
	        dto.setBookingId(b.getBookingId());
	        dto.setBookedAt(b.getBookedAt());
	        dto.setBookDate(b.getBookDate());
	        dto.setTotalFare(b.getTotalFare());
	        dto.setStatus(b.getStatus());
	        dto.setUsername(b.getUsername());
	        dto.setOrigin(b.getOrigin());
	        dto.setDestination(b.getDestination());

	        if (b.getFlight() != null) {
	            dto.setFlightCode(b.getFlight().getFlightCode());
	            dto.setFlightName(b.getFlight().getName());
	        }

	        dtoList.add(dto);
	    }

	    return dtoList;
	}

	


//	@Override
//	public List<Booking> getBookingsByStatus(BookingStatus status) {
//		return bookingRepository.findByStatus(status);
//	}

	@Override
	public List<BookingDTO> getBookingsByStatus(BookingStatus status) {
	    List<Booking> bookings = bookingRepository.findByStatus(status);
	    List<BookingDTO> dtoList = new ArrayList<>();

	    for (Booking b : bookings) {
	        BookingDTO dto = new BookingDTO();
	        dto.setBookingId(b.getBookingId());
	        dto.setBookedAt(b.getBookedAt());
	        dto.setBookDate(b.getBookDate());
	        dto.setTotalFare(b.getTotalFare());
	        dto.setStatus(b.getStatus());
	        dto.setUsername(b.getUsername());
	        dto.setOrigin(b.getOrigin());
	        dto.setDestination(b.getDestination());

	        if (b.getFlight() != null) {
	            dto.setFlightCode(b.getFlight().getFlightCode());
	            dto.setFlightName(b.getFlight().getName());
	        }

	        dtoList.add(dto);
	    }

	    return dtoList;
	}
	

}