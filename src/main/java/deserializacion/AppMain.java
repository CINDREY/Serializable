package deserializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AppMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/path/to//serialized-book.txt"); //Update path accordingly
        ObjectInputStream ois = new ObjectInputStream(fis);

        Book bookFromAnotherApp = (Book) ois.readObject();
        ois.close();

        System.out.println(bookFromAnotherApp.getId());
        System.out.println(bookFromAnotherApp.getTitle());
        System.out.println(bookFromAnotherApp.isAvailable());
    }
}