package org.eshop.persistence.impl;

import org.eshop.entity.Orderstatus;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.OrderstatusDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Repository
public class OrderstatusDAOimpl extends AbstractDAO implements OrderstatusDAO {
    public void insertOrderstatus(Orderstatus orderstatus) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(orderstatus);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteOrderstatus(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Orderstatus orderstatus = session.load(Orderstatus.class, orderId);
            session.delete(orderstatus);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void updateOrderstatus(Orderstatus orderstatus) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(orderstatus);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Orderstatus getOrderstatus(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Orderstatus orderstatus = session.get(Orderstatus.class, orderId);
            transaction.commit();
            return orderstatus;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
