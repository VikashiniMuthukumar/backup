package com.hexaware.simplyfly.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RouteFlightDTO {
    private double baseFare;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private int checkInBaggageLimit;
    private int cabinBaggageLimit;

    public RouteFlightDTO() {}

    public RouteFlightDTO(double baseFare, LocalDateTime arrivalTime, LocalDateTime departureTime,
                          int checkInBaggageLimit, int cabinBaggageLimit) {
        this.baseFare = baseFare;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.checkInBaggageLimit = checkInBaggageLimit;
        this.cabinBaggageLimit = cabinBaggageLimit;
    }

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getCheckInBaggageLimit() {
		return checkInBaggageLimit;
	}

	public void setCheckInBaggageLimit(int checkInBaggageLimit) {
		this.checkInBaggageLimit = checkInBaggageLimit;
	}

	public int getCabinBaggageLimit() {
		return cabinBaggageLimit;
	}

	public void setCabinBaggageLimit(int cabinBaggageLimit) {
		this.cabinBaggageLimit = cabinBaggageLimit;
	}

	@Override
	public String toString() {
		return "RouteFlightDTO [baseFare=" + baseFare + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", checkInBaggageLimit=" + checkInBaggageLimit + ", cabinBaggageLimit="
				+ cabinBaggageLimit + "]";
	}

    
}
