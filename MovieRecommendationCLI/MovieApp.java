import java.util.Scanner;

public class MovieApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Movie Recommendation CLI App!");
        Scanner sc = new Scanner(System.in);
        MovieLibrary library = new MovieLibrary();
        library.addMovie(new Movie(1, "Inception", "Sci-Fi", 8.8, 2010));
        library.addMovie(new Movie(2, "Interstellar", "Sci-Fi", 8.6, 2014));
        library.addMovie(new Movie(3, "Parasite", "Thriller", 8.6, 2008));
        library.addMovie(new Movie(4, "The Dark Knight", "Action", 9.0, 2008));
        while(true) {
            System.out.println("\n Movie Recommendation System");
            System.out.println("1. view All Movies");
            System.out.println("2. Search by title");
            System.out.println("3. Filter by Genre");
            System.out.println("4. Sort by rating");
            System.out.println("5. Sort by year");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                library.getAllMovies().forEach(System.out::println);
            }
                case 2 -> {
                    System.out.println("Enter title");
                    String title = sc.nextLine();
                    library.searchByTitle(title).ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Movie not found")
                    );
                }
                case 3 -> {
                    System.out.println("Enter Genre");
                    String genre = sc.nextLine();
                    library.filterByGenre(genre).forEach(System.out::println);
                }
                case 4 -> {
                    library.sortRatingByDescending().forEach(System.out::println);
                }
                case 5 -> {
                    library.sortByYearDescending().forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("Good Bye!");
                    return;
                }
                default -> {
                    System.out.println("Invalid option!");
                }
            }

        }

    }
}
