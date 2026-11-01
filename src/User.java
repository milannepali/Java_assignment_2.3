
import java.util.ArrayList;

public class User {

    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Get user name
    public String getName() {
        return name;
    }

    // Get user age
    public int getAge() {
        return age;
    }

    // Get borrowed books
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book through the library
    public void borrowBook(Library library, String title) {
        Book book = library.findAvailableBook(title);

        if (book != null) {
            library.borrowBook(title);
            borrowedBooks.add(book);
            System.out.println(name + " borrowed: " + title);
        } else {
            System.out.println("Book not available: " + title);
        }
    }

    // Return a book to the library
    public void returnBook(Library library, Book book) {
        if (borrowedBooks.remove(book)) {
            library.returnBook(book);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println(name + " has not borrowed this book.");
        }
    }

    // Display borrowed books
    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");

        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}
