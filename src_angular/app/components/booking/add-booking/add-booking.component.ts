// import { Component } from '@angular/core';
// import { Booking } from 'src/app/model/booking';
// import { BookingService } from 'src/app/service/booking service/booking.service';

// @Component({
//   selector: 'app-add-booking',
//   templateUrl: './add-booking.component.html',
//   styleUrls: ['./add-booking.component.css'],
// })
// export class AddBookingComponent {
//   booking: Booking = {
//     bookedAt: new Date().toISOString(),
//     status: 'CONFIRMED',
//     totalFare: 0,
//   };

//   message = '';

//   constructor(private bookingService: BookingService) {}

//   addBooking(form: any) {
//     if (form.valid) {
//       this.booking.bookedAt = new Date().toISOString(); // Ensure fresh time
//       this.bookingService.addBooking(this.booking).subscribe({
//         next: (res) => {
//           this.message = res;
//           form.resetForm();
//           this.booking.status = 'CONFIRMED';
//           this.booking.totalFare = 0;
//         },
//         error: (err) => {
//           this.message = 'Booking failed: ' + err.error;
//         },
//       });
//     }
//   }
// }


import { Component, OnInit } from '@angular/core';
import { RouteService } from 'src/app/service/route service/route.service';
import { FlightService } from 'src/app/service/flight service/flight.service';
import { BookingService } from 'src/app/service/booking service/booking.service';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {

  booking: any = {
    username: '',
    flightCode: '',
    flightName: '',  // flight name
    origin: '',
    destination: '',
    arrivalTime: '',
    departureTime: '',
    baseFare: '',
    checkInBaggageLimit: '',
    cabinBaggageLimit: '',
    status: 'CONFIRMED',
    totalFare: 0,
    bookDate: '',     // LocalDate (yyyy-MM-dd)
    bookedAt: ''      // LocalDateTime (ISO)
  };

  message: string = '';
  flightOptions: any[] = [];
  origins: string[] = [];
  destinations: string[] = [];

  constructor(
    private routeService: RouteService,
    private flightService: FlightService,
    private bookingService: BookingService
  ) {}

  ngOnInit(): void {
    this.flightService.getAllFlights().subscribe({
      next: (flights) => {
        this.flightOptions = flights;
      },
      error: (err) => {
        console.error("Failed to fetch flights:", err);
      }
    });
  }

  onFlightCodeSelect() {
    const flightCode = this.booking.flightCode;
    const selectedFlight = this.flightOptions.find(f => f.flightCode === flightCode);
    this.booking.flightName = selectedFlight ? selectedFlight.name : '';

    this.routeService.getRoutesByFlightCode(flightCode).subscribe(routes => {
      this.origins = [...new Set(routes.map(r => r.origin))];
      this.destinations = [...new Set(routes.map(r => r.destination))];
      this.booking.origin = '';
      this.booking.destination = '';
    });

    this.flightService.getFlightByCode(flightCode).subscribe(flight => {
      this.booking.checkInBaggageLimit = flight.checkInBaggageLimit;
      this.booking.cabinBaggageLimit = flight.cabinBaggageLimit;
    });
  }

  onRouteSelect() {
    const { origin, destination, flightCode } = this.booking;
    if (origin && destination && flightCode) {
      this.routeService.getRouteFlightInfo(origin, destination, flightCode).subscribe(data => {
        this.booking.arrivalTime = data.arrivalTime;
        this.booking.departureTime = data.departureTime;
        this.booking.baseFare = data.baseFare;
        this.booking.totalFare = data.baseFare;
      });
    }
  }

  submitBooking() {
    // Set correct formats for backend
    this.booking.bookedAt = new Date().toISOString(); // full ISO for LocalDateTime
    this.booking.bookDate = new Date().toISOString().substring(0, 10); // yyyy-MM-dd for LocalDate

    this.bookingService.addBooking(this.booking).subscribe({
      next: (res) => {
        this.message = res;
        this.booking = {
          username: '',
          flightCode: '',
          flightName: '',
          origin: '',
          destination: '',
          arrivalTime: '',
          departureTime: '',
          baseFare: '',
          checkInBaggageLimit: '',
          cabinBaggageLimit: '',
          status: 'CONFIRMED',
          totalFare: 0,
          bookDate: '',
          bookedAt: ''
        };
      },
      error: (err) => {
        this.message = 'Booking failed: ' + err.error;
      }
    });
  }
}
