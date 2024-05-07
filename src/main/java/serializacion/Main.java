package serializacion;

import serializacion.model.Book;
import serializacion.model.Librarian;
import serializacion.model.Library;
import serializacion.model.Member;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        Book firstBook = new Book("Sherlock Holmes");
        Book secondBook = new Book("Por qué fracasan los países");
        Book thirdBook = new Book("Jesús ocúpate tú");

        Librarian librarian = new Librarian("Bibliotecario");
        Member member = new Member("Javier");

        Library library = new Library();

        librarian.addBook(library, firstBook);
        librarian.addBook(library, secondBook);
        librarian.addBook(library, thirdBook);

        member.requestBook(library, 1);
        member.requestBook(library, 2);

        //Serialize the third book to a file
        try (FileOutputStream fos = new FileOutputStream("serialized-book.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(thirdBook);
        } catch (Exception ex) {
            System.out.println("Something went wrong: " + ex.getMessage());
        }
    }
}


