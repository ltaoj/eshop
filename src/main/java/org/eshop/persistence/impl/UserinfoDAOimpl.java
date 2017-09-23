package org.eshop.persistence.impl;

import org.eshop.entity.Userinfo;
import org.eshop.persistence.AbstractDAO;
import org.eshop.persistence.UserinfoDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hsqldb.rights.User;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Repository
public class UserinfoDAOimpl extends AbstractDAO implements UserinfoDAO {
    private static final int CHANGE_BASIC_INFO = 0;
    private static final int CHANGE_EMAIL = 1;
    private static final int CHANGE_PHONE = 2;

    public void insertUserinfo(Userinfo userinfo) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            session.save(userinfo);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    public void changeBasic(Userinfo userinfo) throws PersistenceException {
        updateUserInfo(userinfo, CHANGE_BASIC_INFO);
    }

    public void changeEmail(String loginId, String email) throws PersistenceException {
        Userinfo userinfo = new Userinfo();
        userinfo.setLoginId(loginId);
        userinfo.setEmail(email);
        updateUserInfo(userinfo, CHANGE_EMAIL);
    }

    public void changePhone(String loginId, String phone) throws PersistenceException {
        Userinfo userinfo = new Userinfo();
        userinfo.setLoginId(loginId);
        userinfo.setPhone(phone);
        updateUserInfo(userinfo, CHANGE_PHONE);
    }

    public Userinfo getUserinfo(String loginId) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        try {
            Userinfo userinfo = session.get(Userinfo.class, loginId);
            transaction.commit();
            return userinfo;
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new PersistenceException(e);
        } finally {
            session.close();
        }
    }

    private void updateUserInfo(Userinfo userinfo, int operateType) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = getTransation(session);
        String hql = "update Userinfo as u";
        switch (operateType) {
            case CHANGE_BASIC_INFO:
                hql += " set u.sex=" + userinfo.getSex();
                hql += ", u.name='" + userinfo.getName() + "'";
                break;
            case CHANGE_EMAIL:
                hql += " set u.email='" + userinfo.getEmail() + "'";
                break;
            case CHANGE_PHONE:
                hql += " set u.phone='" + userinfo.getPhone() + "'";
                break;
        }
        hql += " where u.loginId='" + userinfo.getLoginId() + "'";
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
