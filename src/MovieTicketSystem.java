import java.util.*;

public class MovieTicketSystem {
    private static List<Movie> movieList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedMovies();

        while (true) {
            clearScreen();
            System.out.println("--- Marvel Ticket Booking System ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Continue as Customer");
            System.out.println("0. Exit");
            System.out.print("\nChoose an option: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> adminLogin();
                case 2 -> customerMenu();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private static void adminLogin() {
        clearScreen();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        Admin admin = new Admin(movieList);
        if (Admin.authenticate(password)) {
            System.out.println("Access granted.");
            adminMenu(admin);
        } else {
            System.out.println("Incorrect password.");
        }
        pressEnterToContinue();
    }

    private static void customerMenu() {
        Booking booking = new Booking();

        while (true) {
            clearScreen();
            System.out.println("-- Customer Menu --");
            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");
            System.out.println("0. Back to Main Menu");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    viewMovies();
                    pressEnterToContinue();
                }
                case 2 -> {
                    viewMovies();
                    System.out.println();
                    System.out.print("Enter the movie title to book: ");
                    String title = scanner.nextLine();
                    bookTicket(title, booking);
                    pressEnterToContinue();
                }
                case 3 -> {
                    System.out.print("Enter the movie title to cancel: ");
                    String title = scanner.nextLine();
                    cancelBooking(title, booking);
                    pressEnterToContinue();
                }
                case 4 -> {
                    booking.viewBookings();
                    pressEnterToContinue();
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private static void adminMenu(Admin admin) {
        while (true) {
            clearScreen();
            System.out.println("-- Admin Panel --");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Remove Movie");
            System.out.println("0. Logout");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Showtime: ");
                    String showtime = scanner.nextLine();
                    System.out.print("Seats: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine();
                    admin.addMovie(title, showtime, seats);
                    System.out.println("Movie added.");
                    pressEnterToContinue();
                }
                case 2 -> {
                    System.out.print("Title to update: ");
                    String title = scanner.nextLine();
                    System.out.print("New Showtime: ");
                    String showtime = scanner.nextLine();
                    System.out.print("New Seats: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine();
                    admin.updateMovie(title, showtime, seats);
                    System.out.println("Movie updated.");
                    pressEnterToContinue();
                }
                case 3 -> {
                    System.out.print("Title to remove: ");
                    String title = scanner.nextLine();
                    admin.removeMovie(title);
                    System.out.println("Movie removed.");
                    pressEnterToContinue();
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid admin choice.");
            }
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear screen.");
        }
    }

    private static void pressEnterToContinue() {
        System.out.print("\nPress ENTER to return...");
        scanner.nextLine();
    }

    private static void viewMovies() {
        if (movieList.isEmpty()) {
            System.out.println("No movies currently listed.");
        } else {
            movieList.forEach(System.out::println);
        }
    }

    private static void bookTicket(String title, Booking booking) {
        for (Movie m : movieList) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                if (booking.book(m)) {
                    System.out.println("Booking successful!");
                } else {
                    System.out.println("No available seats.");
                }
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    private static void cancelBooking(String title, Booking booking) {
        if (booking.cancel(title)) {
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("You have no booking under that title.");
        }
    }

    private static void seedMovies() {
        movieList.add(new Movie("Iron Man", "12:00PM", 10));
        movieList.add(new Movie("Black Panther", "3:00PM", 8));
        movieList.add(new Movie("Endgame", "6:00PM", 5));
    }
}
