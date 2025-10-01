import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    public void removeBook(int bookId) {
        for(Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                System.out.println("Book removed: "+ book.getTitle());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + "not found.");
    }
    public ArrayList<Book> searchBookByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if(!foundBooks.isEmpty()) {
            return foundBooks;
        }
        else {
            return null;
            }
    }
    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if(!foundBooks.isEmpty()) {
            return foundBooks;
        }
        else {
            return null;
        }
    }
    public void displayAllBooks() {
        if(books.isEmpty()) {
            System.out.println("No books currrently in the library.");
            return;
        }
        for(Book book : books) {
            System.out.println(book);
        }
        return;
    }
    public void displayAllAvailableBooks() {
        boolean hasAvailableBooks = false;
        for(Book book : books) {
            if(book.isAvailable()) {
                System.out.println(book);
                hasAvailableBooks = true;
            }
        }
        if(!hasAvailableBooks) {
            System.out.println("No available Books at the moment.");
        }
        return;
    }
    public void borrowBook(int bookId) {
        for(Book book : books) {
            if(book.getId() == bookId) {
                if(book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You have borrowed: "+ book.getTitle());
                }
                else {
                    System.out.println("Sorry, the book is currently not available.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found. ");
    }
    public void returnBook(int bookID) {
        for(Book book : books) {
            if(book.getId() == bookID) {
                if(!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You have returned: " + book.getTitle());
                }
                else {
                    System.out.println("This book was not borrowed from this library.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }
}
