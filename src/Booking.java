import java.util.*;

public class Booking {
    private Map<String, Movie> bookedMovies = new HashMap<>();

    public boolean book(Movie movie) {
        if (movie.bookSeat()) {
            bookedMovies.put(movie.getTitle(), movie);
            return true;
        }
        return false;
    }

    public boolean cancel(String title) {
        if (bookedMovies.containsKey(title)) {
            Movie movie = bookedMovies.remove(title);
            movie.cancelSeat();
            return true;
        }
        return false;
    }

    public void viewBookings() {
        if (bookedMovies.isEmpty()) {
            System.out.println("No current bookings.");
        } else {
            bookedMovies.values().forEach(System.out::println);
        }
    }
}
