package Utilities.Book;

import Utilities.Code;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Reader {
    public static final int CARD_NUMBR_ = 0;
    public static final int NAME_ = 1;
    public static final int PHONE_NUMBER_ = 2;
    public static final int BOOK_COUNT_ = 3;
    public static final int BOOK_STARTS_ = 4;

    private int cardNUMber;
    private String name;
    private String phone;
    private List<Book> books;

    public Reader(int cardNumber, String name, String phone) {
        this.cardNUMber = cardNumber;
        this.name = name;
        this.phone = phone;
        this.books = new ArrayList<>();

    }

    public Code addBook(Book book) {
        if (this.books.contains(book)) {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        }

        books.add(book);
        return Code.SUCCESS;
    }

    public Code removeBook(Book book) {
        if (books.contains(book)) {
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        }
        if (books.remove(book)) {
            return Code.SUCCESS;
        }
        return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;


    }
    public boolean hasBook(Book book) {
        return books.contains(book);
    }
    public int getBookCount() {
        return books.size();
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public int getCardNumber() {
        return cardNUMber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNUMber = cardNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if(!(obj instanceof Reader))
          return false;
      Reader reader = (Reader)obj;
      return cardNUMber == reader.cardNUMber &&
              Objects.equals(name, reader.name) &&
                Objects.equals(phone, reader.phone);

    }
    @Override
    public int hashCode() {
        return Objects.hash(cardNUMber, name, phone);
    }
    @Override
    public String toString() {
        return name + "  (" + phone + ") has checked out " + books;
    }
}