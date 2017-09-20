package org.eshop.persistence;

import org.eshop.entity.Signon;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface SignonDAO {

    /**
     * 获取登录信息
     * @param userId
     * @return
     * @throws PersistenceException
     */
    Signon getSignon(String userId) throws PersistenceException;

    /**
     * 插入登录信息
     * @param signon
     * @throws PersistenceException
     */
    void insertSignon(Signon signon) throws PersistenceException;

    /**
     * 修改用户邮箱
     * @param loginId
     * @param email
     * @throws PersistenceException
     */
    void changeEmail(String loginId, String email) throws PersistenceException;

    /**
     * 修改用户手机号码
     * @param loginId
     * @param phone
     * @throws PersistenceException
     */
    void changePhone(String loginId, String phone) throws PersistenceException;

    /**
     * 修改用户密码
     * @param loginId
     * @param password
     * @throws PersistenceException
     */
    void changePassword(String loginId, String password) throws PersistenceException;
}
