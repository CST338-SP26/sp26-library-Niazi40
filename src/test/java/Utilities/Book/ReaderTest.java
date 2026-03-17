package Utilities.Book;

import Utilities.Code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {

    private Reader reader;
    private Book book;

    @BeforeEach
    void setUp() {
        reader = new Reader(1001, "ReaderName", "0000000000");
        book = new Book();
    }


    @Test
    void testConstructor() {
        Reader r = new Reader(2000, "TestReader", "1111111111");

        assertEquals(2000, r.getCardNumber());
        assertEquals("TestReader", r.getName());
        assertEquals("1111111111", r.getPhone());
        assertEquals(0, r.getBookCount());
    }


    @Test
    void testAddBookSuccess() {
        Code result = reader.addBook(book);

        assertEquals(Code.SUCCESS, result);
        assertTrue(reader.hasBook(book));
        assertEquals(1, reader.getBookCount());
    }


    @Test
    void testAddBookDuplicate() {
        reader.addBook(book);

        Code result = reader.addBook(book);

        assertEquals(Code.BOOK_ALREADY_CHECKED_OUT_ERROR, result);
    }


    @Test
    void testRemoveBookSuccess() {
        reader.addBook(book);

        Code result = reader.removeBook(book);

        assertEquals(Code.SUCCESS, result);
        assertFalse(reader.hasBook(book));
    }

    // removeBook when reader does not have the book
    @Test
    void testRemoveBookNotOwned() {
        Code result = reader.removeBook(book);

        assertEquals(Code.READER_DOESNT_HAVE_BOOK_ERROR, result);
    }

    @Test
    void testSetName() {
        reader.setName("UpdatedName");
        assertEquals("UpdatedName", reader.getName());
    }

    @Test
    void testSetPhone() {
        reader.setPhone("2222222222");
        assertEquals("2222222222", reader.getPhone());
    }

    @Test
    void testSetCardNumber() {
        reader.setCardNumber(9999);
        assertEquals(9999, reader.getCardNumber());
    }

    @Test
    void testSetBooks() {
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book);

        reader.setBooks(newBooks);

        assertEquals(1, reader.getBookCount());
    }

    @Test
    void testEquals() {
        Reader r1 = new Reader(1, "Name", "123");
        Reader r2 = new Reader(1, "Name", "123");

        assertEquals(r1, r2);
    }

    @Test
    void testHashCode() {
        Reader r1 = new Reader(1, "Name", "123");
        Reader r2 = new Reader(1, "Name", "123");

        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        String result = reader.toString();

        assertTrue(result.contains("ReaderName"));
        assertTrue(result.contains("0000000000"));
    }
}