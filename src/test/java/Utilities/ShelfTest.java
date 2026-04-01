package Utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ShelfTest {

    @Test
    public void testConstructorAndGetters() {
        Shelf shelf = new Shelf(1, "Fantasy");

        assertEquals(1, shelf.getShelfNumber());
        assertEquals("Fantasy", shelf.getSubject());
        assertTrue(shelf.getBooks().isEmpty());
    }

    @Test
    public void testSetters() {
        Shelf shelf = new Shelf();

        HashMap<Book, Integer> books = new HashMap<>();
        shelf.setBooks(books);
        shelf.setShelfNumber(2);
        shelf.setSubject("Sci-Fi");

        assertEquals(2, shelf.getShelfNumber());
        assertEquals("Sci-Fi", shelf.getSubject());
        assertEquals(books, shelf.getBooks());
    }

    @Test
    public void testAddBookSuccess() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        Utilities.Code result = shelf.addBook(book);

        Assertions.assertEquals(Code.SUCCESS, result);
        assertEquals(1, shelf.getBookCount(book));
    }

    @Test
    public void testAddBookDuplicate() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        shelf.addBook(book);
        shelf.addBook(book);

        assertEquals(2, shelf.getBookCount(book));
    }

    @Test
    public void testAddBookSubjectMismatch() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Sci-Fi", 100, "Author", LocalDate.now());

        Code result = shelf.addBook(book);

        assertEquals(Code.SHELF_SUBJECT_MISMATCH_ERROR, result);
    }

    @Test
    public void testRemoveBookSuccess() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        shelf.addBook(book);
        Code result = shelf.removeBook(book);

        assertEquals(Code.SUCCESS, result);
        assertEquals(0, shelf.getBookCount(book));
    }

    @Test
    public void testRemoveBookNotFound() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        Code result = shelf.removeBook(book);

        assertEquals(Code.BOOK_NOT_IN_INVENTORY_ERROR, result);
    }

    @Test
    public void testGetBookCountNotExists() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        assertEquals(-1, shelf.getBookCount(book));
    }

    @Test
    public void testEqualsAndHashCode() {
        Shelf shelf1 = new Shelf(1, "Fantasy");
        Shelf shelf2 = new Shelf(1, "Fantasy");

        assertEquals(shelf1, shelf2);
        assertEquals(shelf1.hashCode(), shelf2.hashCode());
    }

    @Test
    public void testToString() {
        Shelf shelf = new Shelf(5, "History");

        assertEquals("5 : History", shelf.toString());
    }

    @Test
    public void testListBooks() {
        Shelf shelf = new Shelf(1, "Fantasy");

        Book book = new Book("123", "Test Book", "Fantasy", 100, "Author", LocalDate.now());

        shelf.addBook(book);

        String result = shelf.listBooks();

        assertTrue(result.contains("1 books on shelf"));
        assertTrue(result.contains("Test Book"));
    }
}