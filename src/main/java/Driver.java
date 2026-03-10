import java.time.LocalDate;
public class Driver {
    public static void main(String[] args) {
        Book book = new Book("1337","Headfirst Java","Education",1337,"Grady Booch", LocalDate.of(2025,11,3));

        Book book2 = new Book("42-w-87","Hitchhikers Guide To the Galaxy","sci-fi",42,"Douglas Adams", LocalDate.of(2022,12,1));


        Book book3 = book;


    }
}
