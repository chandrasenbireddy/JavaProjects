import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieLibrary {
    private List<Movie> movies = new ArrayList<>();
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    //search by title case insensitive
    public Optional<Movie> searchByTitle(String title) {
        return movies.stream().filter(m -> m.getTitle().equalsIgnoreCase(title)).findFirst();
    }
    // Filter by Genre
    public List<Movie> filterByGenre(String genre) {
        return movies.stream().filter(m->m.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }
    //Sort by rating
    public List<Movie> sortRatingByDescending() {
        return movies.stream().sorted(Comparator.comparingDouble(Movie::getRating).reversed()).collect(Collectors.toList());
    }
    //sort by year
    public List<Movie> sortByYearDescending() {
        return movies.stream().sorted(Comparator.comparingInt(Movie::getReleaseYear).reversed()).collect(Collectors.toList());
    }
    //get all movies
    public List<Movie> getAllMovies() {
        return movies;
    }
}
