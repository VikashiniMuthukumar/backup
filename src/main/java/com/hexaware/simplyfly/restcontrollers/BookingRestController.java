package com.hexaware.simplyfly.restcontrollers;

/**
 * REST controller for managing bookings.
 * Provides endpoints for CRUD operations on Booking entities.
 * 
 * Author: Vikashini
 * Version: 1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.simplyfly.dto.BookingDTO;
import com.hexaware.simplyfly.entities.Booking;
import com.hexaware.simplyfly.enums.BookingStatus;
import com.hexaware.simplyfly.exceptions.BookingNotFoundException;
import com.hexaware.simplyfly.exceptions.RouteNotFoundException;
import com.hexaware.simplyfly.exceptions.UserNotFoundException;
import com.hexaware.simplyfly.services.IBookingService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<String> createBooking(@Valid @RequestBody BookingDTO dto) 
            throws UserNotFoundException, RouteNotFoundException{
        log.info("Creating booking with data: {}", dto);
        Booking booking = bookingService.createBooking(dto);
        log.info("Booking created with ID: {}", booking.getBookingId());
        return new ResponseEntity<>("Booking created successfully with ID: " + booking.getBookingId(), HttpStatus.CREATED);
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateBooking(@PathVariable Long bookingId, @Valid @RequestBody BookingDTO dto) 
            throws BookingNotFoundException, UserNotFoundException, RouteNotFoundException {
        log.info("Updating booking with ID: {}", bookingId);
        Booking booking = bookingService.updateBooking(bookingId, dto);
        log.info("Booking updated: {}", booking);
        return ResponseEntity.ok("Booking updated successfully for ID: " + booking.getBookingId());
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
        log.warn("Deleting booking with ID: {}", bookingId);
        bookingService.deleteBooking(bookingId);
        log.info("Booking deleted with ID: {}", bookingId);
        return ResponseEntity.ok("Booking deleted successfully for ID: " + bookingId);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Object> getBookingById(@PathVariable Long bookingId) throws BookingNotFoundException {
        log.info("Fetching booking with ID: {}", bookingId);
        Booking booking = bookingService.getBookingById(bookingId);
        log.info("Booking fetched: {}", booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<Object> getAllBookings() {
        log.info("Fetching all bookings");
        List<BookingDTO> bookings = bookingService.getAllBookings();
        log.info("Total bookings fetched: {}", bookings.size());
        return ResponseEntity.ok(bookings);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BookingDTO>> getBookingsByStatus(@PathVariable String status) throws BookingNotFoundException {
        log.info("Fetching bookings with status: {}", status);
        BookingStatus bookingStatus;
        try {
            bookingStatus = BookingStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value. Use CONFIRMED or CANCELLED.");
        }
        List<BookingDTO> bookings = bookingService.getBookingsByStatus(bookingStatus);
        return ResponseEntity.ok(bookings);
    }
    
//    @GetMapping("/bookings/status/{status}")
//    public ResponseEntity<List<Booking>> getBookingsByStatus(@PathVariable String status) throws BookingNotFoundException {
//        try {
//            BookingStatus enumStatus = BookingStatus.valueOf(status.toUpperCase());
//            List<Booking> bookings = bookingService.getBookingsByStatus(enumStatus);
//            return ResponseEntity.ok(bookings);
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Invalid status value. Use CONFIRMED or CANCELLED.");
//        }
//    }


}