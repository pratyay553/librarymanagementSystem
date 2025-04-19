
import java.util.ArrayList;
import java.util.Collections;
public class Library {

    ArrayList<Book> b = new ArrayList<>();

    public void addBook(Object o) {
        Book newBook = (Book)o;
        int k=0;
        for (Book book : b) {
            if (book.getBookId().equals(newBook.getBookId())) {
                System.out.println("Book Id is duplicate ");
                k++;
                break;
            }
        }
        if(k==0){
             b.add(newBook);
             System.out.println("Book added successfully");
            }
        System.out.println("-------------------------------------------------------");
    }

    public void removeBook(String bookId) {
        int k=0;
        for (Book book : b) {
            if (book.getBookId().equals(bookId)) {
                System.out.println("removed book is : ");
                System.out.println(book);
                b.remove(book);
                k++;
                break;
            }
        }
        if (k==0) {
            System.out.println("book not found");  
        }
        System.out.println("-------------------------------------------------------");
    }

    public void removeBook(Book bk){
        for (Book book : b) {
            if(book.equals(bk)){
                b.remove(book);
            }else{
                System.out.println("no book exist with these details");
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    public void display() {
        for (Book book : b) {
            System.out.println("Book Id is : " + book.getBookId());
            System.out.println("Book Name is : " + book.getBookName());
            System.out.println("Book Author Name is : " + book.getBookAuthorName());
            System.out.println("Book Price is : " + book.getBookPrice());
        }

        System.out.println("-------------------------------------------------------");
    }

    public void searchBook(String bookName) {
        int k = 0;
        for (Book book : b) {
            if (bookName.equals(book.getBookName())) {
                System.out.println("-------------book is available and these are book details -----");

                System.out.println("Book Id is : " + book.getBookId());
                System.out.println("Book Name is : " + book.getBookName());
                System.out.println("Book Author Name is : " + book.getBookAuthorName());
                System.out.println("Book Price is : " + book.getBookPrice());
                k++;
            }
        }
        if(k==0){
            System.out.println("Book is not available");
        }
        System.out.println("-------------------------------------------------------");
    }

    public ArrayList<Book> displayDesc(){
        // b.sort(Comparator.comparing(Book::getBookPrice).reversed());
        Collections.sort(b.reversed());
       return b;
       
    }

    public ArrayList<Book> displayAsc() {
        // b.sort(Comparator.comparing(Book::getBookPrice));
        Collections.sort(b);
        return b;
    }
}
