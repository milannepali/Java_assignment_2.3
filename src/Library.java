
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all available books
    public void displayBooks() {
        System.out.println("Library Catalog:");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            System.out.println((i + 1) + ". Title: \""
                    + book.getTitle() + "\", Author: \""
                    + book.getAuthor() + "\", Year: "
                    + book.getPublicationYear());
        }
    }

    // Find books by author
    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");

        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: \"" + book.getTitle()
                        + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    // Find an available book
    public Book findAvailableBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Borrow a book
    public void borrowBook(String title) {
        Book book = findAvailableBook(title);

        if (book != null) {
            books.remove(book);
            System.out.println("Borrowed: " + title);
        } else {
            System.out.println("Book not available: " + title);
        }
    }

    // Return a book
    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Returned: " + book.getTitle());
    }

    // Check availability
    public boolean isBookAvailable(String title) {
        return findAvailableBook(title) != null;
    }

    // Calculate average rating
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Book book : books) {
            total += book.getRating();
        }

        return total / books.size();
    }

    // Find most reviewed book
    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book mostReviewed = books.get(0);

        for (Book book : books) {
            if (book.getReviewCount() > mostReviewed.getReviewCount()) {
                mostReviewed = book;
            }
        }

        return mostReviewed;
    }

    // Add a user
    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    // Remove a user
    public void removeUser(User user) {
        if (user.getBorrowedBooks().isEmpty()) {
            users.remove(user);
        } else {
            System.out.println("Return borrowed books before removing user.");
        }
    }

    // Find user by name
    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }

    // Display library users
    public void displayUsers() {
        System.out.println("Library Users:");

        for (User user : users) {
            System.out.println(user.getName()
                    + ", Age: " + user.getAge());

            user.displayBorrowedBooks();
        }
    }
}
