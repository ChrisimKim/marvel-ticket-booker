# Marvel Movie Ticket Booking System

## Overview
The **Marvel Movie Ticket Booking System** is a Java-based application that allows users to browse and book tickets for all released Marvel movies. The system supports both **Customers** and **Administrators**, offering a user-friendly experience via a Command-Line Interface (CLI) or an optional Graphical User Interface (GUI). Designed using object-oriented programming principles, the system features robust architecture and comprehensive UML documentation.

This project is developed as part of the final assignment for the Object-Oriented Programming course at NYU.

## Features

### Customer Features
- **Browse Movies**: View a list of all 35 released Marvel movies.
- **Search Options**: Filter movies by title, chronological order, or showtime.
- **Book Tickets**: Select a movie and reserve available seats.
- **Manage Bookings**: View and cancel your existing reservations.

### Admin Features (pw: marvel123)
- **Add Movies**: Insert new Marvel movie entries into the system.
- **Update Listings**: Modify showtime or available seats for an existing movie.
- **Remove Movies**: Delete movies from the system when necessary.

## System Design

- `MovieTicketSystem` Class  
  Central system controller that manages all user interactions and links subsystems.

- `Movie` Class  
  Represents a Marvel movie, including title, showtime, and available seats.

- `Booking` Class  
  Handles ticket reservation and cancellation logic for customers.

- `Admin` Class  
  Supports administrative operations including creating, updating, and deleting movies.

## UML Diagrams
All necessary UML documentation will be included in the `diagrams/` directory:
- Use Case Diagram
- Sequence Diagram
- Class Diagram

## Technology Stack
- **Language**: Java
- **Interface**: Command-Line Interface (CLI)
- **Version Control**: GitHub repository for collaborative development and contribution tracking

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR-USERNAME/marvel-ticket-booking-system.git
   cd marvel-ticket-booking-system
   ```

2. Compile and run the program (Java):
   ```bash
   cd src
   javac MovieTicketSystem.java
   java MovieTicketSystem
   ```

## Team Members
- **Iva Park** – cp3588@nyu.edu  
- **Chrisim Kim** – ck3388@nyu.edu  

## License
This project is for educational purposes and is not affiliated with Marvel or Disney.
