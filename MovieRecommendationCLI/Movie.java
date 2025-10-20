public class Movie {
    private int id;
    private String title;
    private String genre;
    private double rating;
    private int releaseYear;
    public Movie(int id, String title, String genre, double rating, int releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    public int getId() {return id;}
    public String getTitle() { return title;}
    public String getGenre() { return genre;}
    public double getRating() { return rating;}
    public int getReleaseYear() { return releaseYear;}
    @Override
    public String toString() {
        return String.format("id: %d, Title: %s, Genre: %s, Rating: %f, Release Year: %d", id, title, genre, rating, releaseYear);
    }
}
