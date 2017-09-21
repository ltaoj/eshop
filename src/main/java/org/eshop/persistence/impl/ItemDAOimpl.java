package org.eshop.persistence.impl;

import org.eshop.entity.Item;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.ItemDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Repository
public class ItemDAOimpl extends AbstractDAO implements ItemDAO {
    public void insertItem(Item item) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(item);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void updateItem(Item item) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(item);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Item getItem(String itemId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Item item = session.get(Item.class, itemId);
            transaction.commit();
            return item;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Item> getItemListByCategoryIdPaging(String categoryId, int offset, int count) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
             String hql = "from Item as i where i.categoryId='" + categoryId + "'";
             Query query = session.createQuery(hql);
             query.setFirstResult(offset);
             query.setMaxResults(count);
             List<Item> list = query.list();
             transaction.commit();
             return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Item> getItemListByKeyword(String keyword) throws PersistenceException {
        return null;
    }
}
