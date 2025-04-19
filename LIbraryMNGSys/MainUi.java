
import java.util.Scanner;

public class MainUi {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Library l = new Library();
            boolean flag = true;
            System.out.println("----------------------------------Welcome To Your Own Library------------------------------");
            do {
                System.out.println("1. Add Book inside Library");
                System.out.println("2. Remove Book from Library");
                System.out.println("3. Display All Book Details from Library");
                System.out.println("4. Check book availablity");
                System.out.println("5. Display All Book Details with a filter condition ");
                
                System.out.println("6. Exit ");
                
                System.out.println("-----------------------------------");
                System.out.println();
                System.out.println("Enter Your choice..");
                int ch = sc.nextInt();
                
                switch (ch) {
                    case 1 -> {
                        System.out.println("Enter the BookName : ");
                        String name = sc.nextLine() + sc.nextLine();
                        System.out.println("Enter the BookAuthorName : ");
                        String AuthN = sc.nextLine();
                        System.out.println("Enter the BookId : ");
                        String bi = sc.nextLine();
                        System.out.println("Enter the BookPrice : ");
                        double price = sc.nextDouble();
                        l.addBook(new Book(name, AuthN, bi, price));
                    }
                    
                    case 2 -> {
                        System.out.println("---- Choose the remove option ----");
                        
                        System.out.println("---- type 0 for remove a book by providing the bookId ---");
                        System.out.println("---- type 1 for remove a book by providing the book details ---");
                        int c = sc.nextInt();
                        switch (c) {
                            case 0 -> {
                                System.out.print("Enter the book id");
                                String bid = sc.nextLine() + sc.nextLine();
                                l.removeBook(bid);
                            }
                            case 1 -> {
                                System.out.println("Enter the BookName : ");
                                String name = sc.nextLine() + sc.nextLine();
                                System.out.println("Enter the BookAuthorName : ");
                                String AuthN = sc.nextLine();
                                System.out.println("Enter the BookId : ");
                                String bi = sc.nextLine();
                                System.out.println("Enter the BookPrice : ");
                                double price = sc.nextDouble();
                                l.removeBook(new Book(bi, name, AuthN, price));
                            }
                            default ->
                                throw new AssertionError();
                        }
                        
                    }
                    case 3 ->
                        l.display();
                        
                    case 4 -> {
                        System.out.println("Enter the book name");
                        String bName = sc.nextLine()+sc.nextLine();  
                        l.searchBook(bName);
                    }
                    case 5 ->{
                        System.out.println("--- Type 0 for filter basis on insertion order ---");
                        System.out.println("--- Type 1 for filter basis on price Ascending order ---");
                        System.out.println("--- Type 2 for filter basis on price descending order ---");
                        int cs = sc.nextInt();
                        switch (cs) {
                            case 0 ->{
                                l.display();
                            }
                            case 1 ->{
                                System.out.println(l.displayAsc());
                                System.out.println("-------------------------------------------------------");
                            }
                            case  2 -> {
                                System.out.println(l.displayDesc());
                                System.out.println("-------------------------------------------------------");
                            }
                            
                            default -> throw new AssertionError();
                        }
                        
                    }
                    case 6 ->
                        flag = false;
                    default ->
                        throw new AssertionError();
                }
            } while (flag);
        }
    }
}
