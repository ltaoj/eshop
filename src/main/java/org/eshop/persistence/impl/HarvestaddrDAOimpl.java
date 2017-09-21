package org.eshop.persistence.impl;

import org.eshop.domain.Constant;
import org.eshop.entity.Harvestaddr;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.HarvestaddrDAO;
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
public class HarvestaddrDAOimpl extends AbstractDAO implements HarvestaddrDAO {
    public void insertHarvestaddr(Harvestaddr harvestaddr) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(harvestaddr);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteHarvestaddr(int addrId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Harvestaddr harvestaddr = session.load(Harvestaddr.class, addrId);
            session.delete(harvestaddr);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void updateHarvestaddr(Harvestaddr harvestaddr) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.update(harvestaddr);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void setDefaultHarvestaddr(int addrId, String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Harvestaddr harvestaddr = session.get(Harvestaddr.class, addrId);
            if (harvestaddr != null && harvestaddr.getLoginId().equals(loginId)) {
                String hql = "update Harvestaddr as h set h.useDefault=" + Constant.UNUSE_ADDR_AS_DEFAULT + " where h.loginId='" + loginId + "'";
                session.createQuery(hql).executeUpdate();
                harvestaddr.setUseDefault(Constant.USE_ADDR_AS_DEFAULT);
                session.update(harvestaddr);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Harvestaddr getDefaultHarvestaddr(String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Harvestaddr as h where h.loginId='" + loginId + "' and h.useDefault=" + Constant.USE_ADDR_AS_DEFAULT;
            List<Harvestaddr> list = session.createQuery(hql).list();
            transaction.commit();
            return list.size() > 0 ? list.get(0) : null;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
