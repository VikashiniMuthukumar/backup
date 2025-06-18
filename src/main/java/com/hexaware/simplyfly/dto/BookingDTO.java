package com.hexaware.simplyfly.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hexaware.simplyfly.enums.BookingStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * BookingDTO carries booking details with validation.
 * 
 * @author Vikashini
 * @version 1.0
 */

public class BookingDTO {

	private Long bookingId;

	@NotNull
	private LocalDateTime bookedAt;

	@NotNull
	private BookingStatus status;

	@NotNull
	@Positive
	private Double totalFare;

	@NotBlank
	private String username;

	@NotBlank
	private String origin;

	@NotBlank
	private String destination;

	@NotNull
	private LocalDate bookDate;

	@NotBlank
	private String flightCode;

	@NotBlank
	private String flightName;
	
//	private Double fare;
//	private String departureTime;
//	private String arrivalTime;
//
//	private int cabinBaggageLimit;
//	private int checkInBaggageLimit;


	public BookingDTO() {
		super();
	}

	public BookingDTO(Long bookingId, @NotNull LocalDateTime bookedAt, @NotNull BookingStatus status,
			@NotNull @Positive Double totalFare, @NotBlank String username, @NotBlank String origin,
			@NotBlank String destination, @NotNull LocalDate bookDate, @NotBlank String flightCode,
			@NotBlank String flightName) {
		super();
		this.bookingId = bookingId;
		this.bookedAt = bookedAt;
		this.status = status;
		this.totalFare = totalFare;
		this.username = username;
		this.origin = origin;
		this.destination = destination;
		this.bookDate = bookDate;
		this.flightCode = flightCode;
		this.flightName = flightName;
	}

	// Getters and Setters

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


	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", bookedAt=" + bookedAt + ", status=" + status + ", totalFare="
				+ totalFare + ", username=" + username + ", origin=" + origin + ", destination=" + destination
				+ ", bookDate=" + bookDate + ", flightCode=" + flightCode + ", flightName=" + flightName + "]";
	}
}

/*public class BookingDTO {

private Long bookingId;

@NotNull
private LocalDateTime bookedAt;

@NotNull
private BookingStatus status;

@NotNull
@Positive
private Double totalFare;


//  @NotNull
//  @Positive 
//  private Long user_id;
//  
//  @NotNull
//  @Positive 
//  private Long route_id;
 

public BookingDTO() {
	super();
}

public BookingDTO(Long bookingId, @NotNull LocalDateTime bookedAt, @NotNull BookingStatus status,
		@NotNull @Positive Double totalFare  ,@NotNull @Positive Long user_id, @NotNull @Positive Long route_id ) {
	super();
	this.bookingId = bookingId;
	this.bookedAt = bookedAt;
	this.status = status;
	this.totalFare = totalFare;
								 * this.user_id = user_id; this.route_id = route_id;
								 
}

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


 * public Long getUser_id() { return user_id; }
 * 
 * public void setUser_id(Long user_id) { this.user_id = user_id; }
 * 
 * public Long getRoute_id() { return route_id; }
 * 
 * public void setRoute_id(Long route_id) { this.route_id = route_id; }
 

@Override
public String toString() {
	return "BookingDTO [bookingId=" + bookingId + ", bookedAt=" + bookedAt + ", status=" + status + ", totalFare="
			+ totalFare  + ", user_id=" + user_id + ", route_id=" + route_id  + "]";
}

}*/
