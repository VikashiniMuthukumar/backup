import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Route } from 'src/app/model/flightroute';

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  private baseUrl = 'http://localhost:8081/api/routes';

  constructor(private http: HttpClient) {}

  getAllRoutes(): Observable<Route[]> {
    return this.http.get<Route[]>(`${this.baseUrl}/getAll`);
  }

  deleteRoute(id: number): Observable<string> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  updateRoute(id: number, route: Route): Observable<string> {
    return this.http.put(`${this.baseUrl}/update/${id}`, route, { responseType: 'text' });
  }

  addRoute(route: Route): Observable<string> {
    return this.http.post(`${this.baseUrl}/add`, route, { responseType: 'text' });
  }

  getRouteById(id: number): Observable<Route> {
    return this.http.get<Route>(`${this.baseUrl}/${id}`);
  }

  getRoutesByFlightCode(flightCode: string): Observable<Route[]> {
    return this.http.get<Route[]>(`${this.baseUrl}/flightCode/${flightCode}`);
  }

  getRouteFlightInfo(origin: string, destination: string, flightCode: string): Observable<any> {
    const params = new HttpParams()
      .set('origin', origin)
      .set('destination', destination)
      .set('flightCode', flightCode);

    return this.http.get(`${this.baseUrl}/route-flight-info`, { params });
  }
  getOriginsAndDestinationsByFlightCode(flightCode: string): Observable<any> {
  return this.http.get(`${this.baseUrl}/origins-destinations/${flightCode}`);
}

  
}
