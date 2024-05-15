package com.app.bookstore.Test;

import com.app.bookstore.daos.BorrowerDao;
import com.app.bookstore.models.Address;
import com.app.bookstore.models.Borrower;

public class BorrowerTest {
    public static void main(String[] args) {
        BorrowerDao borrowerDao = new BorrowerDao();
        // Adding a borrower
        Borrower borrower = new Borrower();
        borrower.setName("John Doe");
        borrower.setEmail("john.doe@gmail.com");
        Address address = new Address("USA","New York","123 Main St");
        borrower.setAddress(address);
        borrowerDao.addBorrower(borrower);
        System.out.println("Borrower added successfully!");

        // Updating a borrower
        Borrower borrowerToUpdate = borrowerDao.getBorrowerById(1);
        if (borrowerToUpdate != null) {
            borrowerToUpdate.setName("Jane Doe");
            borrowerToUpdate.setEmail("jane.doe@example.com");
            borrowerDao.updateBorrower(borrowerToUpdate);
            System.out.println("Borrower updated successfully!");
        } else {
            System.out.println("Borrower not found!");
        }

        // Getting a borrower by id
        Borrower existingBorrower = borrowerDao.getBorrowerById(1);
        if (existingBorrower != null) {
            System.out.println("Borrower name: " + existingBorrower.getName());
            System.out.println("Borrower email: " + existingBorrower.getEmail());
            System.out.println("Borrower address: " + existingBorrower.getAddress().getCountry() + ", " +
                    existingBorrower.getAddress().getCity() + ", " +
                    existingBorrower.getAddress().getStreet());
        } else {
            System.out.println("Borrower not found!");
        }

        // Deleting a borrower
        Borrower borrowerToDelete = borrowerDao.getBorrowerById(1);
        if (borrowerToDelete != null) {
            borrowerDao.deleteBorrower(borrowerToDelete);
            System.out.println("Borrower deleted successfully!");
        } else {
            System.out.println("Borrower not found!");
        }
    }
}
