package org.eshop.persistence.impl;

import org.eshop.entity.Signon;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.SignonDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Repository
public class SignonDAOimpl extends AbstractDAO implements SignonDAO {
    private static final int CHANGE_EMAIL = 1;
    private static final int CHANGE_PHONE = 2;
    private static final int CHANGE_PASSWORD = 3;

    public Signon getSignon(String userId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Signon signon = session.get(Signon.class, userId);
            transaction.commit();
            return signon;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void insertSignon(Signon signon) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(signon);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void changeEmail(String userId, String email) throws PersistenceException {
        Signon signon = new Signon();
        signon.setUserId(userId);
        signon.setEmail(email);
        updateSignon(signon, CHANGE_EMAIL);
    }

    public void changePhone(String userId, String phone) throws PersistenceException {
        Signon signon = new Signon();
        signon.setUserId(userId);
        signon.setPhone(phone);
        updateSignon(signon, CHANGE_PHONE);
    }

    public void changePassword(String userId, String password) throws PersistenceException {
        Signon signon = new Signon();
        signon.setUserId(userId);
        signon.setPassword(password);
        updateSignon(signon, CHANGE_PASSWORD);
    }

    private void updateSignon(Signon signon, int operateType) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        String hql = "update Signon as s";
        switch (operateType) {
            case CHANGE_EMAIL:
                hql += " set s.email=" + signon.getEmail();
                break;
            case CHANGE_PHONE:
                hql += " set s.phone=" + signon.getPhone();
                break;
            case CHANGE_PASSWORD:
                hql += " set s.password=" + signon.getPassword();
                break;
        }
        hql += " where s.userId=" + signon.getUserId();
        try {
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
