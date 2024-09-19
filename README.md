**Railway Reservation System**
**Overview**
The Railway Reservation System is a Java-based application that allows administrators and passengers to manage train reservations efficiently. The system offers a range of functionalities for both admins and passengers, with real-time updates on train availability, booking information, and seat management. Data is stored and retrieved using a file-based storage system.

**Features**
**Admin Features:**
Add, Delete, and Update Train Details: Admins can manage the train database by adding new trains, updating existing train information, and removing outdated or canceled trains.
View Passenger Information: Admins have the ability to view detailed information about passengers who have booked tickets on specific trains.

**Passenger Features:**
View Available Trains: Passengers can search and view all available trains, along with details such as departure time, destination, and seat availability.
Book Tickets and Manage Reservations: Passengers can book tickets, select seats, and manage their reservations. Seat availability is updated in real-time to ensure accurate booking.
Dummy Payment System: A simulated payment system is implemented to handle booking costs. Passengers can calculate the total booking cost and simulate payment for their reservations. Seat availability is updated after a successful payment.

**Technologies Used**
Programming Language: Java
Data Storage: File-based data storage for managing train and passenger details.
Payment Simulation: A dummy payment system to handle ticket pricing and simulate payment transactions.

**Usage Instructions**
**For Admins:**
Login: Admins can log in using pre-defined credentials.
Manage Trains: Use the options in the admin dashboard to add, delete, or update train details.
View Passengers: Access passenger information for any train, including details on their reservations.

**For Passengers:**
View Trains: Passengers can view a list of available trains, along with seat availability and timings.
Book Tickets: Select a train, choose the number of tickets, and confirm the booking by simulating a payment.

**File-Based Storage**
All train details and passenger information are stored in text files. These files are automatically updated whenever train details are changed or reservations are made.

License
This project is licensed under the MIT License - see the LICENSE file for details.
