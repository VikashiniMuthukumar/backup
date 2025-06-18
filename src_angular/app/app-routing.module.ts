import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookingComponent } from './components/booking/add-booking/add-booking.component';
import { FlightDashboardComponent } from './components/dashboard/flight-dashboard/flight-dashboard.component';
import { RouteDashboardComponent } from './components/dashboard/route-dashboard/route-dashboard.component';
import { DisplayBookingComponent } from './components/booking/display-booking/display-booking.component';
import { SearchBookingComponent } from './components/booking/search-booking/search-booking.component';
import { MainDashboardComponent } from './components/dashboard/main-dashboard/main-dashboard.component';
import { BookDashboardComponent } from './components/dashboard/book-dashboard/book-dashboard.component';
import { SearchFlightComponent } from './components/flight/search-flight/search-flight.component';
import { AddRouteComponent } from './components/route/add-route/add-route.component';
import { SearchRouteComponent } from './components/route/search-route/search-route.component';
import { DisplayRouteComponent } from './components/route/display-route/display-route.component';
import { DisplayFlightComponent } from './components/flight/display-flight/display-flight.component';
import { AddflightComponent } from './components/flight/addflight/addflight.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'main', component: MainDashboardComponent },
  {path: 'book', component:BookDashboardComponent},
  { path: 'route', component: RouteDashboardComponent },
  { path: 'flight', component: FlightDashboardComponent },
  { path: 'addbooking', component: AddBookingComponent },
  { path: 'displaybookings', component: DisplayBookingComponent },
  { path: 'searchbooking', component: SearchBookingComponent },
  { path: 'addroute', component: AddRouteComponent },
{ path: 'displayroutes', component: DisplayRouteComponent },
{ path: 'searchroute', component: SearchRouteComponent },

{ path: 'addflight', component: AddflightComponent },
{ path: 'displayflights', component: DisplayFlightComponent },
{ path: 'searchflight', component: SearchFlightComponent },
{ path: 'login', component: LoginComponent},
  // optional: child routes for each
  { path: '', redirectTo: '/book', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
