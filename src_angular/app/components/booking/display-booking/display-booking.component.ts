// import { Component, OnInit } from '@angular/core';
// import { Booking } from 'src/app/model/booking';
// import { BookingService } from 'src/app/service/booking service/booking.service';

// @Component({
//   selector: 'app-display-booking',
//   templateUrl: './display-booking.component.html',
//   styleUrls: ['./display-booking.component.css'],
// })
// export class DisplayBookingComponent /*implements OnInit */{
  // bookings: Booking[] = [];
  // selectedBooking: Booking = new Booking();
  // showEditModal: boolean = false;

  // constructor(private bookingService: BookingService) {}

  // ngOnInit(): void {
  //   this.getAllBookings();
  // }

  // getAllBookings() {
  //   this.bookingService.getAllBookings().subscribe({
  //     next: (data) => {
  //       this.bookings = data;
  //     },
  //     error: (err) => {
  //       alert('Error fetching bookings');
  //       console.error(err);
  //     },
  //   });
  // }

  // deleteBooking(id?: number) {
  //   if (!id) {
  //     alert('Booking ID is missing, cannot delete.');
  //     return;
  //   }

  //   if (confirm('Are you sure you want to delete this booking?')) {
  //     this.bookingService.deleteBooking(id).subscribe({
  //       next: () => {
  //         alert('Booking deleted successfully');
  //         this.getAllBookings();
  //       },
  //       error: (err) => {
  //         alert('Error deleting booking');
  //         console.error(err);
  //       },
  //     });
  //   }
  // }

  // openEditModal(booking: Booking) {
  //   this.selectedBooking = { ...booking }; // clone to avoid direct binding
  //   this.showEditModal = true;
  // }

  // closeModal() {
  //   this.showEditModal = false;
  // }

  // updateBooking() {
  //   if (!this.selectedBooking.bookingId) {
  //     alert('Booking ID is undefined, cannot update.');
  //     return;
  //   }

  //   // Only sending fields that are editable
  //   const updatedBooking: Booking = {
  //     bookingId: this.selectedBooking.bookingId,
  //     status: this.selectedBooking.status,
  //     totalFare: this.selectedBooking.totalFare,
  //     bookedAt: this.selectedBooking.bookedAt,
  //   };

  //   this.bookingService
  //     .updateBooking(this.selectedBooking.bookingId, updatedBooking)
  //     .subscribe({
  //       next: () => {
  //         alert('Booking updated successfully');
  //         this.getAllBookings();
  //         this.closeModal();
  //       },
  //       error: (err) => {
  //         alert('Error updating booking');
  //         console.error(err);
  //       },
  //     });
  // }

//   bookings: Booking[] = [];

//   constructor(private bookingService: BookingService) {}

//   ngOnInit(): void {
//   this.bookingService.getAllBookings().subscribe((data) => {
//     console.log('Bookings:', data); // 👈 check what you're getting
//     this.bookings = data;
//   });
// }


//   getAllBookings() {
//     this.bookingService.getAllBookings().subscribe({
//       next: (data) => {
//         this.bookings = data;
//       },
//       error: (err) => {
//         console.error('Failed to fetch bookings', err);
//       }
//     });
//   }

//   deleteBooking(bookingId: number) {
//     if (confirm('Are you sure you want to delete this booking?')) {
//       this.bookingService.deleteBooking(bookingId).subscribe({
//         next: () => {
//           alert('Booking deleted successfully');
//           this.getAllBookings();
//         },
//         error: (err) => {
//           console.error('Delete error', err);
//           alert('Error deleting booking');
//         }
//       });
//     }
//   }
// }


import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking';
import { BookingService } from 'src/app/service/booking service/booking.service';

@Component({
  selector: 'app-display-booking',
  templateUrl: './display-booking.component.html',
  styleUrls: ['./display-booking.component.css']
})
export class DisplayBookingComponent implements OnInit {

  bookings: Booking[] = [];
  selectedBooking: Booking = new Booking();
  showEditModal: boolean = false;

  constructor(private bookingService: BookingService) {}

  ngOnInit(): void {
    this.getAllBookings();
  }

  getAllBookings() {
    this.bookingService.getAllBookings().subscribe({
      next: (data) => {
        this.bookings = data;
      },
      error: (err) => {
        console.error('Failed to fetch bookings', err);
      }
    });
  }

  deleteBooking(bookingId: number) {
    if (confirm('Are you sure you want to delete this booking?')) {
      this.bookingService.deleteBooking(bookingId).subscribe({
        next: () => {
          alert('Booking deleted successfully');
          this.getAllBookings();
        },
        error: (err) => {
          console.error('Delete error', err);
          alert('Error deleting booking');
        }
      });
    }
  }

  openEditModal(booking: Booking) {
    this.selectedBooking = { ...booking };
    this.showEditModal = true;
  }

  closeModal() {
    this.showEditModal = false;
  }

  updateBooking() {
    this.bookingService.updateBooking(this.selectedBooking.bookingId!, this.selectedBooking).subscribe({
      next: () => {
        alert('Booking updated successfully');
        this.getAllBookings();
        this.closeModal();
      },
      error: (err) => {
        console.error('Update error', err);
        alert('Error updating booking');
      }
    });
  }
}
