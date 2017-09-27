package org.eshop.persistence.impl;

import org.eshop.domain.Constant;
import org.eshop.entity.Harvestaddr;
import org.eshop.entity.Inventory;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.InventoryDAO;
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
public class InventoryDAOimpl extends AbstractDAO implements InventoryDAO {
    public void updateInventory(Inventory inventory) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(inventory);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Inventory getInventory(String itemId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Inventory as i where i.itemId='" + itemId + "'";
            List<Inventory> list = session.createQuery(hql).list();
            transaction.commit();
            return list.size() > 0 ? list.get(0) : null;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void insertInventory(Inventory inventory) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(inventory);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
