package com.app.bookstore.Test;

import com.app.bookstore.daos.AuthorDao;
import com.app.bookstore.daos.BookDao;
import com.app.bookstore.daos.BorrowerDao;
import com.app.bookstore.models.Address;
import com.app.bookstore.models.Author;
import com.app.bookstore.models.Book;
import com.app.bookstore.models.Borrower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MappingTest {
    public static void main(String[] args) {
        // Adding books
        BookDao bookDao = new BookDao();
        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("90-84-56-76");
        book1.setPublicationYear(1990);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("90-9-5-6");
        book2.setPublicationYear(2000);
        bookDao.addBook(book2);

        Book book3 = new Book();
        book3.setTitle("Book 3");
        book3.setIsbn("90-9-5-6");
        book3.setPublicationYear(2002);
        bookDao.addBook(book3);

        // Adding authors
        AuthorDao authorDao = new AuthorDao();
        Author author1 = new Author();
        author1.setName("Author 1");
        author1.setEmail("Author1@gmail.com");
        author1.setBooks(Arrays.asList(book1,book2,book3));
        authorDao.addAuthor(author1);

        Author author2 = new Author();
        author2.setName("Author 2");
        author2.setEmail("Author2@gmail.com");
        author2.setBooks(Arrays.asList(book1,book3));
        authorDao.addAuthor(author2);

        Author author3 = new Author();
        author3.setName("Author 3");
        author3.setEmail("Author3@gmail.com");
        author3.setBooks(Arrays.asList(book1));
        authorDao.addAuthor(author3);
        System.out.println("Authors added successfully!");


        // Adding borrowers
        BorrowerDao borrowerDao = new BorrowerDao();
        Borrower borrower1 = new Borrower();
        borrower1.setName("Borrower 1");
        borrower1.setEmail("Borrower1@gmail.com");
        Address addressOfBorrower1 = new Address("Borrower1Country","Borrower1City","Borrower1Street");
        borrower1.setAddress(addressOfBorrower1);
        borrower1.setBooks(Arrays.asList(book1));
        borrowerDao.addBorrower(borrower1);

        Borrower borrower2 = new Borrower();
        borrower2.setName("Borrower 2");
        borrower2.setEmail("Borrower2@gmail.com");
        Address addressOfBorrower2 = new Address("Borrower2Country","Borrower2City","Borrower2Street");
        borrower2.setAddress(addressOfBorrower2);
        borrower2.setBooks(Arrays.asList(book2,book3));
        borrowerDao.addBorrower(borrower2);

        Borrower borrower3 = new Borrower();
        borrower3.setName("Borrower 3");
        borrower3.setEmail("Borrower3@gmail.com");
        Address addressOfBorrower3 = new Address("Borrower3Country","Borrower3City","Borrower3Street");
        borrower3.setAddress(addressOfBorrower3);
        borrower3.setBooks(Arrays.asList(book1,book2,book3));
        borrowerDao.addBorrower(borrower3);
        System.out.println("Borrowers added successfully!");
    }
}
