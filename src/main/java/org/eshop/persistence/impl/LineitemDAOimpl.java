package org.eshop.persistence.impl;

import org.eshop.entity.Lineitem;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.LineitemDAO;
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
public class LineitemDAOimpl extends AbstractDAO implements LineitemDAO {
    public void insertLineitemList(List<Lineitem> lineitemList) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            for (Lineitem lineitem : lineitemList) {
                session.save(lineitem);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteLineitemByOrderId(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "delete from Lineitem as l where l.orderId='" + orderId + "'";
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Lineitem> getLineitemListByOrderId(String orderId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Lineitem as l where l.orderId='" + orderId + "'";
            List<Lineitem> list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
