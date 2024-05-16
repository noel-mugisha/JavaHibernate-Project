package com.app.bookstore;

import com.app.bookstore.daos.AuthorDao;
import com.app.bookstore.daos.BookDao;
import com.app.bookstore.daos.BorrowerDao;
import com.app.bookstore.models.Address;
import com.app.bookstore.models.Author;
import com.app.bookstore.models.Book;
import com.app.bookstore.models.Borrower;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookDao bookDao = new BookDao();
    private static final AuthorDao authorDao = new AuthorDao();
    private static final BorrowerDao borrowerDao = new BorrowerDao();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bookstore Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Author");
            System.out.println("3. Add Borrower");
            System.out.println("4. Fetch All Authors");
            System.out.println("5. Fetch All Borrowers");
            System.out.println("6. Fetch All Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addAuthor();
                    break;
                case 3:
                    addBorrower();
                    break;
                case 4:
                    fetchAllAuthors();
                    break;
                case 5:
                    fetchAllBorrowers();
                    break;
                case 6:
                    fetchAllBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter book publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPublicationYear(year);
        bookDao.addBook(book);

        System.out.println("Book added successfully!");
    }

    private static void addAuthor() {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();
        System.out.print("Enter author email: ");
        String email = scanner.nextLine();

        System.out.print("Enter book IDs (comma-separated): ");
        String bookIdsStr = scanner.nextLine();
        List<Integer> bookIds = Arrays.stream(bookIdsStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Book> books = bookDao.getBooksByIds(bookIds);

        Author author = new Author();
        author.setName(name);
        author.setEmail(email);
        author.setBooks(books);
        authorDao.addAuthor(author);

        System.out.println("Author added successfully!");
    }

    private static void addBorrower() {
        System.out.print("Enter borrower name: ");
        String name = scanner.nextLine();
        System.out.print("Enter borrower email: ");
        String email = scanner.nextLine();
        System.out.print("Enter borrower country: ");
        String country = scanner.nextLine();
        System.out.print("Enter borrower city: ");
        String city = scanner.nextLine();
        System.out.print("Enter borrower street: ");
        String street = scanner.nextLine();

        System.out.print("Enter book IDs (comma-separated): ");
        String bookIdsStr = scanner.nextLine();
        List<Integer> bookIds = Arrays.stream(bookIdsStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Book> books = bookDao.getBooksByIds(bookIds);

        Address address = new Address(country, city, street);
        Borrower borrower = new Borrower();
        borrower.setName(name);
        borrower.setEmail(email);
        borrower.setAddress(address);
        borrower.setBooks(books);
        borrowerDao.addBorrower(borrower);

        System.out.println("Borrower added successfully!");
    }

    private static void fetchAllAuthors() {
        List<Author> authors = authorDao.getAllAuthors();
        if (authors.isEmpty()) {
            System.out.println("No authors found.");
        } else {
            for (Author author : authors) {
                System.out.println("Author: " + author.getName() + ", Email: " + author.getEmail());
                for (Book book : author.getBooks()) {
                    System.out.println("  Book: " + book.getTitle());
                }
            }
        }
    }

    private static void fetchAllBorrowers() {
        List<Borrower> borrowers = borrowerDao.getAllBorrowers();
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers found.");
        } else {
            for (Borrower borrower : borrowers) {
                System.out.println("Borrower: " + borrower.getName() + ", Email: " + borrower.getEmail());
                for (Book book : borrower.getBooks()) {
                    System.out.println("  Book: " + book.getTitle());
                }
            }
        }
    }

    private static void fetchAllBooks() {
        List<Book> books = bookDao.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println("Book: " + book.getTitle() + ", ISBN: " + book.getIsbn() + ", Year: " + book.getPublicationYear());
            }
        }
    }
}
