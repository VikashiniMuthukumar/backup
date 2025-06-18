// export class Booking {
//   bookingId?: number = 0;
//   bookedAt: string = '';
//   status: string = '';
//   totalFare: number = 0;
// }


export class Booking {
  bookingId?: number = 0;
  bookedAt: string = ''; // Format: "YYYY-MM-DDTHH:mm:ss"
  status: string = '';   // "CONFIRMED" or "CANCELLED"
  totalFare: number = 0;
  username: string = '';
  origin: string = '';
  destination: string = '';
  bookDate: string = ''; // Format: "YYYY-MM-DD"
  flightCode: string = '';
  flightName: string = '';
}


//   export interface Booking {
//   bookingId?: number; // optional for backend-generated ID
//   username: string;
//   origin: string;
//   destination: string;
//   flightCode: string;
//   flightName: string;
//   status: 'CONFIRMED' | 'CANCELLED';
//   bookDate: string; // Format: YYYY-MM-DD
//   bookedAt?: string; // Optional - if backend sets it
//   totalFare?: number;
// }



// export class BookingModel implements Booking {
//   username: string = '';
//   origin: string = '';
//   destination: string = '';
//   flightCode: string = '';
//   flightName: string = '';
//   status: 'CONFIRMED' | 'CANCELLED' = 'CONFIRMED';
//   bookDate: string = new Date().toISOString().split('T')[0]; // today by default

//   constructor(init?: Partial<BookingModel>) {
//     Object.assign(this, init);
//   }


// }
