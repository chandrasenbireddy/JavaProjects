public class Book {
    private int id;
        private String title;
        private String author;
        private int year;
        private boolean isAvailable;

        public Book(int id, String title, String authour, int year) {
            this.id = id;
            this.title = title;
            this.author = authour;
            this.year = year;
            this.isAvailable = true;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }
        public boolean isAvailable() {
            return isAvailable;
        }
        public void setAvailable(boolean available){
            this.isAvailable = available;
        }
        @Override
        public String toString() {
            return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Year: " + year + ", Available: " + (isAvailable? "Yes" : "No");
        }
}
