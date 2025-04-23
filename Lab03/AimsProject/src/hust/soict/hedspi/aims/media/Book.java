package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media { 
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }


    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author named '" + authorName + "' is already exists.");
        } else {
            authors.add(authorName);
            System.out.println("Author named '" + authorName + "' added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Author named '" + authorName + "' is removed.");
        } else {
            System.out.println("Author named '" + authorName + "' wasn't.");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book - ID: " + getId() + " - Title: " + getTitle() +
                " - Category: " + getCategory() +
                " - Authors: " + String.join(", ", authors) +
                " - Cost: " + getCost() + "$";
    }
}