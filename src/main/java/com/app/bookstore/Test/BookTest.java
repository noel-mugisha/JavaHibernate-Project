package com.app.bookstore.Test;

import com.app.bookstore.daos.BookDao;
import com.app.bookstore.models.Book;

public class BookTest {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        // Adding a book
        Book book = new Book();
        book.setTitle("Harry Potter and the chamber of secrets");
        book.setIsbn("90-84-56-78");
        book.setPublicationYear(1992);
        bookDao.addBook(book);
        System.out.println("Book added successfully!");

        // Updating a book
        Book bookToUpdate = bookDao.getBookById(1);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle("Harry Potter and the prisoner of azkban");
            bookToUpdate.setPublicationYear(1993);
            bookDao.updateBook(bookToUpdate);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }

        // Getting a book by id
        Book existingBook = bookDao.getBookById(2);
        System.out.println(new StringBuilder().append("Book title: ")
                .append(existingBook.getTitle()).append("\nBook publication year: ")
                .append(existingBook.getPublicationYear())
                .append("\nBook ISBN: ").append(existingBook.getIsbn()).toString()
        );

        // Deleting a book
        Book bookToDelete = bookDao.getBookById(1);
        bookDao.deleteBook(bookToDelete);
        System.out.println("Book deleted successfully!");
    }
}
