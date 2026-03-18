import java.time.LocalDate;
import java.util.Objects;

public class Book {
    final static int AUTHOR_ = 4;
    final static int DUE_DATE_ = 5;
    final static int ISBN_ = 0;
    final static int PAGE_COUNT_ = 3;
    final static int SUBJECT_ = 2;
    final static int TITLE_ = 1;

    private String author;
    private LocalDate dueDate;
    private String isbn;
    private int pageCount;
    private String subject;
    private String title;

    //ISBN, Title, Subject, PageCount, Author, DueDate

    public Book(String isbn, String title, String subject, int pageCount, String author, LocalDate dueDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.dueDate = dueDate;
        this.subject = subject;

    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    /// getISBN
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
    //setISBN
    public void setISBN(String newISBN) {

        this.isbn = isbn;
    }

    public void setPageCount(int pageCount) {
        if (pageCount > 0)
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
        if (!(obj instanceof Book book)) return false;
        return pageCount == book.pageCount && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(subject, book.subject) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, isbn, pageCount, subject, title);
    }

    @Override
    public String toString() {
        return this.title + " by " + this.author + " ISBN: " + this.isbn;
    }


}
