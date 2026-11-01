
public class LibraryMain {

    public static void main(String[] args) {

        // Create books
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Create library
        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Task 1: Display books and search by author
        library.displayBooks();

        System.out.println();
        library.findBooksByAuthor("Jane Doe");

        // Tasks 2 and 3: Borrowing and availability
        System.out.println();
        System.out.println("Available before borrowing: "
                + library.isBookAvailable(book2.getTitle()));

        library.borrowBook(book2.getTitle());

        System.out.println("Available after borrowing: "
                + library.isBookAvailable(book2.getTitle()));

        library.returnBook(book2);

        System.out.println("Available after returning: "
                + library.isBookAvailable(book2.getTitle()));

        // Task 4: Ratings and reviews
        book1.setRating(4.5);
        book2.setRating(4.8);
        book3.setRating(4.2);

        book1.addReview("Very useful for beginners!");
        book1.addReview("Easy to understand.");
        book2.addReview("Great book for learning algorithms!");

        System.out.println();
        System.out.println("Book Ratings:");
        System.out.println(book1.getTitle() + ": " + book1.getRating());
        System.out.println(book2.getTitle() + ": " + book2.getRating());
        System.out.println(book3.getTitle() + ": " + book3.getRating());

        System.out.println();
        book1.displayReviews();

        // Task 5: Library statistics
        System.out.println();
        System.out.println("Average book rating: "
                + library.getAverageBookRating());

        Book mostReviewed = library.getMostReviewedBook();

        if (mostReviewed != null) {
            System.out.println("Most reviewed book: "
                    + mostReviewed.getTitle());
        }

        // Task 6: Library users
        System.out.println();
        System.out.println("Testing Library Users:");

        User user1 = new User("Alex", 20);
        User user2 = new User("Emma", 22);

        // Register users
        library.addUser(user1);
        library.addUser(user2);

        // Display registered users
        library.displayUsers();

        // Find a user
        System.out.println();
        User foundUser = library.findUser("Alex");

        if (foundUser != null) {
            System.out.println("Found user: " + foundUser.getName());
        }

        // Borrow books through library
        System.out.println();
        user1.borrowBook(library, book1.getTitle());
        user2.borrowBook(library, book2.getTitle());

        // Display users and borrowed books
        System.out.println();
        library.displayUsers();

        // Check availability
        System.out.println();
        System.out.println("Java book available: "
                + library.isBookAvailable(book1.getTitle()));

        // Return a borrowed book
        System.out.println();
        user1.returnBook(library, book1);

        // Check availability again
        System.out.println("Java book available after return: "
                + library.isBookAvailable(book1.getTitle()));

        // Remove a user with no borrowed books
        library.removeUser(user1);

        System.out.println();
        library.displayUsers();
    }
}
