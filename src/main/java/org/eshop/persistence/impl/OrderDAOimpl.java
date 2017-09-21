package org.eshop.persistence.impl;

import org.eshop.entity.Order;
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
    public String insertOrder(Order order) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(order);
            transaction.commit();
            return order.getOrderId();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteOrder(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Order order = session.load(Order.class, orderId);
            session.delete(order);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Order> getOrderListByLoginId(String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Order as o where o.loginId='" + loginId + "'";
            List<Order> list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Order getOrder(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Order order = session.get(Order.class, orderId);
            transaction.commit();
            return order;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
