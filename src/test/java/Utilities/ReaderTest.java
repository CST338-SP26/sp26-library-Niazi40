package Utilities;

import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    @Test
    void testConstructor() {
        Reader r = new Reader(1, "Jamsheed", "123");

        assertEquals(1, r.getCardNumber());
        assertEquals("Jamsheed", r.getName());
        assertEquals("123", r.getPhone());
        assertEquals(0, r.getBookCount());
    }

    @Test
    void testAddBookSuccess() {
        Reader r = new Reader(1, "Jamsheed", "123");
        Book b = new Book();

        Code result = r.addBook(b);

        assertEquals(Code.SUCCESS, result);
        assertTrue(r.hasBook(b));
        assertEquals(1, r.getBookCount());
    }

    @Test
    void testAddBookDuplicate() {
        Reader r = new Reader(1, "Jamsheed", "123");
        Book b = new Book();

        r.addBook(b);
        Code result = r.addBook(b);

        assertEquals(Code.BOOK_ALREADY_CHECKED_OUT_ERROR, result);
        assertEquals(1, r.getBookCount());
    }

    @Test
    void testRemoveBookLogic() {
        Reader r = new Reader(1, "Jamsheed", "123");
        Book b = new Book();

        r.addBook(b);
        Code result = r.removeBook(b);

        assertEquals(Code.READER_DOESNT_HAVE_BOOK_ERROR, result);
    }

    @Test
    void testHasBook() {
        Reader r = new Reader(1, "Jamsheed", "123");
        Book b = new Book();

        r.addBook(b);

        assertTrue(r.hasBook(b));
    }

    @Test
    void testGetBookCount() {
        Reader r = new Reader(1, "Jamsheed", "123");
        Book b = new Book();

        r.addBook(b);

        assertEquals(1, r.getBookCount());
    }

    @Test
    void testSetBooks() {
        Reader r = new Reader(1, "Jamsheed", "123");

        List<Book> list = new ArrayList<>();
        Book b = new Book();
        list.add(b);

        r.setBooks(list);

        assertEquals(1, r.getBookCount());
        assertTrue(r.hasBook(b));
    }

    @Test
    void testSetters() {
        Reader r = new Reader(1, "Jamsheed", "123");

        r.setCardNumber(10);
        r.setName("Ali");
        r.setPhone("999");

        assertEquals(10, r.getCardNumber());
        assertEquals("Ali", r.getName());
        assertEquals("999", r.getPhone());
    }

    @Test
    void testEquals() {
        Reader r1 = new Reader(1, "Jamsheed", "123");
        Reader r2 = new Reader(1, "Jamsheed", "123");

        assertEquals(r1, r2);
    }

    @Test
    void testHashCode() {
        Reader r1 = new Reader(1, "Jamsheed", "123");
        Reader r2 = new Reader(1, "Jamsheed", "123");

        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        Reader r = new Reader(1, "Jamsheed", "123");

        String result = r.toString();

        assertTrue(result.contains("Jamsheed"));
        assertTrue(result.contains("123"));
    }
}