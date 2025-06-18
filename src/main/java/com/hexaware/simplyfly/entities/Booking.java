//package com.hexaware.simplyfly.entities;
//
//import java.time.LocalDateTime;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.hexaware.simplyfly.enums.BookingStatus;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//
///**
// * Entity representing a Booking made by a User on a Route.
// * Author: Vikashini
// * Version: 1.0
// */
//
//@Entity
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "booking_id")
//    private Long bookingId;
//
//    private LocalDateTime bookedAt = LocalDateTime.now();
//
//    @Enumerated(EnumType.STRING)
//    private BookingStatus status = BookingStatus.CONFIRMED;
//
//    private Double totalFare;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonBackReference
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "route_id")	
//    @JsonManagedReference
//    private Route route;
//
//
//	public Booking() {
//		super();
//	}
//
//
//	public Booking(Long bookingId, LocalDateTime bookedAt, BookingStatus status, Double totalFare, User user,
//			Route route) {
//		super();
//		this.bookingId = bookingId;
//		this.bookedAt = bookedAt;
//		this.status = status;
//		this.totalFare = totalFare;
//		this.user = user;
//		this.route = route;
//	}
//
//
//	public Long getBookingId() {
//		return bookingId;
//	}
//
//
//	public void setBookingId(Long bookingId) {
//		this.bookingId = bookingId;
//	}
//
//
//	public LocalDateTime getBookedAt() {
//		return bookedAt;
//	}
//
//
//	public void setBookedAt(LocalDateTime bookedAt) {
//		this.bookedAt = bookedAt;
//	}
//
//
//	public BookingStatus getStatus() {
//		return status;
//	}
//
//
//	public void setStatus(BookingStatus status) {
//		this.status = status;
//	}
//
//
//	public Double getTotalFare() {
//		return totalFare;
//	}
//
//
//	public void setTotalFare(Double totalFare) {
//		this.totalFare = totalFare;
//	}
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//	public Route getRoute() {
//		return route;
//	}
//
//
//	public void setRoute(Route route) {
//		this.route = route;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Booking [bookingId=" + bookingId + ", bookedAt=" + bookedAt + ", status=" + status + ", totalFare="
//				+ totalFare + ", user=" + user + ", route=" + route + "]";
//	}
//
//	
//   
//}

package com.hexaware.simplyfly.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hexaware.simplyfly.enums.BookingStatus;

import jakarta.persistence.*;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long bookingId;

	private LocalDateTime bookedAt = LocalDateTime.now();

	private LocalDate bookDate; // ✅ NEW

	private String username; // ✅ NEW

	private String origin; // ✅ NEW

	private String destination; // ✅ NEW

	private String flightName;

	private String flightCode;

	@Enumerated(EnumType.STRING)
	private BookingStatus status = BookingStatus.CONFIRMED;

	private Double totalFare;

	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "route_id")
	@JsonManagedReference
	private Route route;

	public Booking() {
		super();
	}

	public Booking(Long bookingId, LocalDateTime bookedAt, LocalDate bookDate, String username, String origin,
			String destination, String flightName, String flightCode, BookingStatus status, Double totalFare,
			Flight flight, User user, Route route) {
		super();
		this.bookingId = bookingId;
		this.bookedAt = bookedAt;
		this.bookDate = bookDate;
		this.username = username;
		this.origin = origin;
		this.destination = destination;
		this.flightName = flightName;
		this.flightCode = flightCode;
		this.status = status;
		this.totalFare = totalFare;
		this.flight = flight;
		this.user = user;
		this.route = route;
	}

	// Getters & Setters for new fields

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	// Existing getters and setters...

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(LocalDateTime bookedAt) {
		this.bookedAt = bookedAt;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	
	

	
	  public User getUser() { return user; }
	  
	  public void setUser(User user) { this.user = user; }
	 

	/*
	 * public UserLogin getUser() { return user; }
	 * 
	 * public void setUser(UserLogin user) { this.user = user; }
	 */

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookedAt=" + bookedAt + ", bookDate=" + bookDate + ", username="
				+ username + ", origin=" + origin + ", destination=" + destination + ", status=" + status
				+ ", totalFare=" + totalFare + ", flight=" + flight + ", user=" + user + ", route=" + route + "]";
	}

}
