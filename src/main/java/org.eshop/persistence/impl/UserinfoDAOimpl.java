package org.eshop.persistence.impl;

import org.eshop.entity.Userinfo;
import org.eshop.persistence.UserinfoDAO;
import org.eshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Repository
public class UserinfoDAOimpl implements UserinfoDAO {
    private static final int CHANGE_BASIC_INFO = 0;
    private static final int CHANGE_EMAIL = 1;
    private static final int CHANGE_PHONE = 2;

    public void insertUserinfo(Userinfo userinfo) throws PersistenceException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
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

    private void updateUserInfo(Userinfo userinfo, int operateType) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update Userinfo as u";
        switch (operateType) {
            case CHANGE_BASIC_INFO:
                hql += " set u.sex=" + userinfo.getSex();
                break;
            case CHANGE_EMAIL:
                hql += " set u.email=" + userinfo.getEmail();
                break;
            case CHANGE_PHONE:
                hql += " set u.phone=" + userinfo.getPhone();
                break;
        }
        hql += " where u.loginId=" + userinfo.getLoginId();
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
