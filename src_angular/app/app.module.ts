import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBookingComponent } from './components/booking/add-booking/add-booking.component';
import { DisplayBookingComponent } from './components/booking/display-booking/display-booking.component';
import { SearchBookingComponent } from './components/booking/search-booking/search-booking.component';
import { AddflightComponent } from './components/flight/addflight/addflight.component';
import { SearchFlightComponent } from './components/flight/search-flight/search-flight.component';
import { DisplayFlightComponent } from './components/flight/display-flight/display-flight.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddRouteComponent } from './components/route/add-route/add-route.component';
import { DisplayRouteComponent } from './components/route/display-route/display-route.component';
import { SearchRouteComponent } from './components/route/search-route/search-route.component';
import { BookDashboardComponent } from './components/dashboard/book-dashboard/book-dashboard.component';
import { FlightDashboardComponent } from './components/dashboard/flight-dashboard/flight-dashboard.component';
import { MainDashboardComponent } from './components/dashboard/main-dashboard/main-dashboard.component';
import { RouteDashboardComponent } from './components/dashboard/route-dashboard/route-dashboard.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    AddBookingComponent,
    DisplayBookingComponent,
    SearchBookingComponent,
    AddflightComponent,
    SearchFlightComponent,
    DisplayFlightComponent,
    AddRouteComponent,
    DisplayRouteComponent,
    SearchRouteComponent,
    BookDashboardComponent,
    FlightDashboardComponent,
    MainDashboardComponent,
    RouteDashboardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
