import model.Author;
import model.Books;
import model.Registration;
import storage.AuthorNotFoundException;
import storage.AuthorStorage;
import storage.BookStorage;
import storage.UserStorage;

import java.util.Scanner;

public class BooksDemo implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static UserStorage userStorage = new UserStorage();



    public static void main(String[] args) {

        Author sevak = new Author("parur","sevak","parursevak@mail.ru","male");
        Author hovanes = new Author("hovanes","tumanyan","hov.tum@mail.ru","male");
        Author silva = new Author("silva","kaputikyan","kaput.sil@mail.ru","female");
        authorStorage.add(sevak);
        authorStorage.add(hovanes);
        authorStorage.add(silva);

        bookStorage.add(new Books("Моя борьба", sevak, 550, 2, "Биография"));
        bookStorage.add(new Books("Капитал", hovanes, 340, 1, "Классика"));
        bookStorage.add(new Books("Паганини", silva, 750, 3, "Биография"));

        boolean run = true;
        while (run) {
            Command.logReg();


            int command = Integer.parseInt(scanner.nextLine());

            if (command == REGISTRATION){
                regUs();
            }
            if (command == LOGIN){
                logUs();
                while (userStorage.getSize() != 0){

                    Command.printCommand();
                    int innerCommand = Integer.parseInt(scanner.nextLine());

                    switch (innerCommand) {
                        case EXIT:
                            run = false;
                            break;
                        case ADD_BOOK:
                            addBooks();
                            break;
                        case PRINT_ALL_BOOKS:
                            bookStorage.printArray();
                            break;
                        case PRINT_BOOKS_BY_AUTHOR_NAME:
                            authorName();
                            break;
                        case PRINT_BOOKS_BY_GENRE:
                            genre();
                            break;
                        case PRINT_BY_PRICE_RANGE:
                            priceRenge();
                            break;
                        case ADD_AUTHOR:
                            addauthor();
                            break;
                        case PRINT_AUTHOR:
                            authorStorage.print();
                            break;
                        case PRINT_AUTHOR_BY_INDEX:
                            authorStorage.print();
                            try {
                                printAuthorByIndex();
                            }catch (AuthorNotFoundException e){
                                System.out.println("no author for index");
                            }

                        default:
                            System.out.println("invalid command");
                    }

                }
            }



        }
    }

    private static void logUs() {
        System.out.println("input login");
        String login = scanner.nextLine();
        System.out.println("input password");
        String password = scanner.nextLine();

        userStorage.loginUser(login,password);
    }

    private static void regUs() {

        System.out.println("input name");
        String name = scanner.nextLine();
        System.out.println("input surname");
        String surname = scanner.nextLine();
        System.out.println("input years");
        int years = Integer.parseInt(scanner.nextLine());
        System.out.println("input login");
        String login = scanner.nextLine();
        System.out.println("input password");
        String password = scanner.nextLine();

        Registration reg = new Registration(name, surname, years, login, password);
        userStorage.regUs(reg);
        System.out.println("user is created");
    }

    private static void printAuthorByIndex() throws AuthorNotFoundException{
        System.out.println("input author index");
        int authorIndex = 0;
        try {
            authorIndex = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("input only number");
            printAuthorByIndex();
        }
        authorStorage.printAuthorByIndex(authorIndex);
    }

    private static Author addauthor(){
        System.out.println("input author name");
        String author = scanner.nextLine();
        System.out.println("input author surname");
        String surname = scanner.nextLine();
        System.out.println("input author email");
        String email = scanner.nextLine();
        System.out.println("chose author gender 1 is male - 2 is female");
        String gender = String.valueOf(scanner.nextLine().charAt(0));
        if (Integer.parseInt(gender) == 1){
            gender = "male";
        }else if(Integer.parseInt(gender) == 2){
            gender = "female";

        }
        Author author1 = new Author(author,surname,email,gender);
        authorStorage.add(author1);
        return author1;


    }

    private static void authorName() {
        System.out.println("please input author name");
        String author = scanner.nextLine();
        bookStorage.printBookByAuthor(author);
    }

    private static void genre() {
        System.out.println("please input book genre");
        String genre = scanner.nextLine();
        bookStorage.printBookByGenre(genre);
    }

    private static void priceRenge() {
        System.out.println("please input first price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("please input last price");
        double price1 = Double.parseDouble(scanner.nextLine());
        bookStorage.printByPriceReng(price, price1);
    }

    private static void addBooks() {
        System.out.println("Please input books title");
        String title = scanner.nextLine();
        Author addNewAuthor = addauthor();
        System.out.println("Please input books price");
        String priceStr = scanner.nextLine();
        System.out.println("Please input books count");
        String countStr = scanner.nextLine();
        System.out.println("Please input books genre");
        String genre = scanner.nextLine();
        double price = 0;
        int count = 0;

        try {
            price = Double.parseDouble(priceStr);
            count = Integer.parseInt(countStr);
        }catch (NumberFormatException e){
            System.out.println("please input only number for price and count");
        }

        Books books = new Books(title, addNewAuthor, price, count, genre);
        bookStorage.add(books);

    }


}
