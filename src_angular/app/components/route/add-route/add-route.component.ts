// import { Component } from '@angular/core';
// import { NgForm } from '@angular/forms';
// import { Route } from 'src/app/model/flightroute';
// import { RouteService } from 'src/app/service/route service/route.service';

// @Component({
//   selector: 'app-add-route',
//   templateUrl: './add-route.component.html',
//   styleUrls: ['./add-route.component.css'],
// })
// export class AddRouteComponent {

//   route: Route = new Route();

//   constructor(private routeService: RouteService) {}

//   insertRoute(form: NgForm) {
//     const value = form.value;

//     value.departureTime = value.departureTime + ':00.000Z';
//     value.arrivalTime = value.arrivalTime + ':00.000Z';

//     this.routeService.addRoute(value).subscribe({
//       next: (res) => alert(res),
//       error: (err) => {
//         console.error(err);
//         alert('Error occurred while adding route');
//       },
//     });
//   }
// }

import { Component, OnInit } from '@angular/core';
import { RouteService } from 'src/app/service/route service/route.service';
import { Route } from 'src/app/model/flightroute';
import { Flight } from 'src/app/model/Flight';
import { FlightService } from 'src/app/service/flight service/flight.service';

@Component({
  selector: 'app-add-route',
  templateUrl: './add-route.component.html',
  styleUrls: ['./add-route.component.css'],
})
export class AddRouteComponent implements OnInit {
  route: Route = new Route();
  flights: Flight[] = [];
  message =  ""

  constructor(
    private routeService: RouteService,
    private flightService: FlightService
  ) {}

  // ngOnInit(): void {
  //   this.flightService.getAllFlights().subscribe((data) => {
  //     this.flights = data;
  //   });
  // }

  ngOnInit(): void {
  this.flightService.getAllFlights().subscribe((data) => {
    this.flights = data;
    console.log("Loaded Flights: ", this.flights); // ✅ Debug log
  });
}


  insertRoute(): void {
    this.route.departureTime += ':00';
    this.route.arrivalTime += ':00';

    this.routeService.addRoute(this.route).subscribe({
      next: (res) => alert(res),
      error: (err) => {
        console.error(err);
        alert('Error occurred while adding route');
      },
    });
  }
}
