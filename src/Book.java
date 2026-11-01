
import java.util.ArrayList;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private double rating = 0;
    private ArrayList<String> reviews = new ArrayList<>();

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Get book title
    public String getTitle() {
        return title;
    }

    // Get author
    public String getAuthor() {
        return author;
    }

    // Get publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    // Set book rating
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    // Get book rating
    public double getRating() {
        return rating;
    }

    // Add a book review
    public void addReview(String review) {
        reviews.add(review);
    }

    // Get number of reviews
    public int getReviewCount() {
        return reviews.size();
    }

    // Display reviews
    public void displayReviews() {
        System.out.println("Reviews for " + title + ":");

        for (String review : reviews) {
            System.out.println("- " + review);
        }
    }
}
