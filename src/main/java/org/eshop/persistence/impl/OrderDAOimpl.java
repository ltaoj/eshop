package org.eshop.persistence.impl;

import org.eshop.entity.Orders;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.OrderDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Repository
public class OrderDAOimpl extends AbstractDAO implements OrderDAO {
    public String insertOrder(Orders Orders) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(Orders);
            transaction.commit();
            return Orders.getOrderId();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteOrder(String OrderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Orders Orders = session.load(Orders.class, OrderId);
            session.delete(Orders);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Orders> getOrderListByLoginId(String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Orders as o where o.loginId='" + loginId + "'";
            List<Orders> list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Orders getOrder(String OrderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Orders Orders = session.get(Orders.class, OrderId);
            transaction.commit();
            return Orders;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
