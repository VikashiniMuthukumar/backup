import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from 'src/app/model/booking';

@Injectable({
  providedIn: 'root',
})
export class BookingService {
  private baseUrl = 'http://localhost:8081/api/bookings';

  constructor(private http: HttpClient) {}

  addBooking(booking: Booking): Observable<string> {
    return this.http.post(`${this.baseUrl}`, booking, { responseType: 'text' });
  }

  getAllBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.baseUrl);
  }

  getBookingById(id: number): Observable<Booking> {
    return this.http.get<Booking>(`${this.baseUrl}/${id}`);
  }

  updateBooking(id: number, booking: Booking): Observable<string> {
    return this.http.put(`${this.baseUrl}/${id}`, booking, {
      responseType: 'text',
    });
  }

  deleteBooking(id: number): Observable<string> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  getBookingsByStatus(status: string): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseUrl}/status/${status}`);
  }



}
