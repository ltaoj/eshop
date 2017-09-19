package org.eshop.persistence;

import org.eshop.entity.Userinfo;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface UserinfoDAO {
    /**
     * 插入用户基本信息
     * @param userinfo
     * @throws PersistenceException
     */
    void insertUserinfo(Userinfo userinfo) throws PersistenceException;

    /**
     * 修改用户邮箱
     * @param loginId
     * @param email
     * @throws PersistenceException
     */
    void changeEmail(String loginId, String email) throws PersistenceException;

    /**
     * 修改用户手机号
     * @param loginId
     * @param phone
     * @throws PersistenceException
     */
    void changePhone(String loginId, String phone) throws PersistenceException;
}
