package com.app.bookstore.daos;

import com.app.bookstore.models.Borrower;
import com.app.bookstore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BorrowerDao {
    // adding a borrower
    public void addBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // updating a borrower
    public void updateBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // deleting a borrower
    public void deleteBorrower(Borrower borrower) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(borrower);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // getting a borrower by id
    public Borrower getBorrowerById(int id) {
        Transaction transaction = null;
        Borrower borrower = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            borrower = session.get(Borrower.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return borrower;
    }
}
