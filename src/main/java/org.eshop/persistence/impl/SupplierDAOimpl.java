package org.eshop.persistence.impl;

import org.eshop.entity.Supplier;
import org.eshop.persistence.SupplierDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Repository
public class SupplierDAOimpl implements SupplierDAO {
    public void insertSupplier(Supplier supplier) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(supplier);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void updateSupplier(Supplier supplier) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(supplier);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
