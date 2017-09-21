package org.eshop.persistence.impl;

import org.eshop.entity.Cartitem;
import org.eshop.entity.CartitemPK;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.CartitemDAO;
import org.eshop.util.Format;
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
public class CartitemDAOimpl extends AbstractDAO implements CartitemDAO {
    public void insertCartitem(Cartitem cartitem) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(cartitem);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteCartitem(String itemId, String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            CartitemPK cartitemPK = new CartitemPK();
            cartitemPK.setItemId(itemId);
            cartitemPK.setLoginId(loginId);
            Cartitem cartitem = session.load(Cartitem.class, cartitemPK);
            session.delete(cartitem);
            transaction.commit();
        }  catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteCartitemList(List<String> itemIds, String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "delete from Cartitem as c where c.itemId in (" + Format.formatList(itemIds)
                    + ") and c.loginId='" + loginId + "'";
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void updateCartitem(Cartitem cartitem) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(cartitem);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Cartitem getCartitem(String itemId, String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            CartitemPK cartitemPK = new CartitemPK();
            cartitemPK.setItemId(itemId);
            cartitemPK.setLoginId(loginId);
            Cartitem cartitem = session.get(Cartitem.class, cartitemPK);
            transaction.commit();
            return cartitem;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public List<Cartitem> getCartitemList(String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Cartitem as c where c.loginId='" + loginId + "'";
            List<Cartitem> list = session.createQuery(hql).list();
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
