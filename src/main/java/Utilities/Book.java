package Utilities;

import java.time.LocalDate;
import java.util.Objects;

public class Book {


    public static final int AUTHOR_ = 0;
    public static final int DUE_DATE_ = 1;
    public static final int ISBN_ = 2;
    public static final int PAGE_COUNT_ = 3;
    public static final int SUBJECT_ = 4;
    public static final int TITLE_ = 5;

    private String author;
    private LocalDate dueDate;
    private String isbn;
    private int pageCount;
    private String subject;
    private String title;


    public Book(String isbn, String title, String subject, int pageCount, String author, LocalDate dueDate) {
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.pageCount = pageCount;
        this.author = author;
        this.dueDate = dueDate;
    }

    public Book() {

    }


    public String getAuthor() {
        return author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getISBN() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book b = (Book) obj;

        return Objects.equals(isbn, b.isbn) &&
                Objects.equals(title, b.title) &&
                Objects.equals(subject, b.subject) &&
                pageCount == b.pageCount &&
                Objects.equals(author, b.author) &&
                Objects.equals(dueDate, b.dueDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subject, pageCount, author, dueDate);
    }


    @Override
    public String toString() {
        return title + " by " + author + " ISBN: " + isbn;
    }
}