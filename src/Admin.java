import java.util.*;

public class Admin {
    private static final String ADMIN_PASSWORD = "marvel123";
    private List<Movie> movieList;

    public Admin(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public static boolean authenticate(String password) {
        return ADMIN_PASSWORD.equals(password);
    }

    public void addMovie(String title, String showtime, int seats) {
        movieList.add(new Movie(title, showtime, seats));
    }

    public void updateMovie(String title, String newShowtime, int newSeats) {
        for (Movie m : movieList) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                m.setShowtime(newShowtime);
                m.setSeatsAvailable(newSeats);
                return;
            }
        }
    }

    public void removeMovie(String title) {
        movieList.removeIf(m -> m.getTitle().equalsIgnoreCase(title));
    }
}
