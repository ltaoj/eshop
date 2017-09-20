package org.eshop.persistence.impl;

import org.eshop.entity.Verifycode;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.VerifycodeDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Repository
public class VerifycodeDAOimpl extends AbstractDAO implements VerifycodeDAO {
    public void insertVerifycode(Verifycode verifycode) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(verifycode);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public Verifycode getVerifycode(String email) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "from Verifycode as v where v.email='" + email + "' order by codeId desc";
            List<Verifycode> list = session.createQuery(hql).list();
            transaction.commit();
            return list.size() > 0 ? list.get(0) : null;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void deleteVerifycode(String email) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            String hql = "delete from Verifycode as v where v.email='" + email + "'";
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }
}
