package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Shelf {


    public static final int SHELF_NUMBER_ = 0;
    public static final int SUBJECT_ = 1;


    private HashMap<Book, Integer> books;
    private int shelfNumber;
    private String subject;


    public Shelf() {
        this.books = new HashMap<>();
    }


    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
        this.books = new HashMap<>();
    }


    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public String getSubject() {
        return subject;
    }


    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Code addBook(Book book) {


        if (!Objects.equals(book.getSubject(), this.subject)) {
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        }


        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
        }

        System.out.println(book.toString() + " added to shelf " + this.toString());
        return Code.SUCCESS;
    }


    public Code removeBook(Book book) {

        if (!books.containsKey(book)) {
            System.out.println(book.getTitle() + " is not on shelf " + subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }

        int count = books.get(book);

        if (count == 0) {
            System.out.println("No copies of " + book.getTitle() + " remain on shelf " + subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        }

        books.put(book, count - 1);

        System.out.println(book.getTitle() + " successfully removed from shelf " + subject);
        return Code.SUCCESS;
    }


    public int getBookCount(Book book) {
        return books.getOrDefault(book, -1);
    }

    public String listBooks() {
        StringBuilder result = new StringBuilder();

        int total = 0;
        for (int count : books.values()) {
            total += count;
        }

        result.append(total)
                .append(" books on shelf: ")
                .append(this.toString())
                .append("\n");

        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            result.append(entry.getKey().toString())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return result.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Shelf)) return false;

        Shelf other = (Shelf) obj;

        return shelfNumber == other.shelfNumber &&
                Objects.equals(subject, other.subject);
    }


    @Override
    public int hashCode() {
        return Objects.hash(shelfNumber, subject);
    }


    @Override
    public String toString() {
        return shelfNumber + " : " + subject;
    }
}