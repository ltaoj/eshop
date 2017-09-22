package org.eshop.persistence.impl;

import org.eshop.domain.Constant;
import org.eshop.entity.Item;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.ItemDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.security.sasl.SaslException;
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

    public List<Item> getItemListByKeyword(String keyword) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Item as i where i.name like '%" + keyword + "%'";
            List<Item> list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Item> getItemListByKeywordPaging(String keyword, int offset, int count) {
        Session session = HibernateUtil.getSession();
        Transaction  transaction = getTransation(session);
        try {
            String hql = "from Item as i where i.name like '%" + keyword + "%'";
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

    public List<Item> getItemListByAttr(String keyword, String type) {
        Session session = HibernateUtil.getSession();
        Transaction  transaction = getTransation(session);
        try {
            String hql = "from Item as i where " + (type.equals(Constant.SEARCH_BY_ATTR_COLOR) ? "i.attr1" : "i.attr2") + " like '%" + keyword + "%'";
            List<Item> list = session.createQuery(hql).list();
            transaction.commit();
            return list;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Item> getItemListByAttrPaging(String keyword, String type, int offset, int count) {
        Session session = HibernateUtil.getSession();
        Transaction  transaction = getTransation(session);
        try {
            String hql = "from Item as i where " + (type.equals(Constant.SEARCH_BY_ATTR_COLOR) ? "i.attr1" : "i.attr2") + " like '%" + keyword + "%'";
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
}
