package com.app.bookstore.Test;

import com.app.bookstore.daos.AuthorDao;
import com.app.bookstore.models.Author;

public class AuthorTest {
    public static void main(String[] args) {
        AuthorDao authorDao = new AuthorDao();
        // Adding an author
        Author author = new Author();
        author.setName("JK Rowling");
        author.setEmail("jkrowling@gmail.com");
        authorDao.addAuthor(author);
        System.out.println("Author added successfully!");

        // Updating an author
        Author authorToUpdate = authorDao.getAuthorById(52);
        if (authorToUpdate != null) {
            authorToUpdate.setName("Joanne Rowling");
            authorToUpdate.setEmail("jrowling@gmail.com");
            authorDao.updateAuthor(authorToUpdate);
            System.out.println("Author updated successfully!");
        } else {
            System.out.println("Author not found!");
        }

        // Getting an author by id
        Author existingAuthor = authorDao.getAuthorById(52);
        System.out.println("Author name is: " + existingAuthor.getName()+"\nThe author's email is: " + existingAuthor.getEmail());

        // Deleting an author
        Author authorToDelete = authorDao.getAuthorById(52);
        authorDao.deleteAuthor(authorToDelete);
        System.out.println("Author deleted successfully!");
    }
}
