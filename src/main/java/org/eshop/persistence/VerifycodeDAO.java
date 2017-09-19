package org.eshop.persistence;

import org.eshop.entity.Verifycode;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface VerifycodeDAO {
    /**
     * 插入验证码
     * @param verifycode
     * @throws PersistenceException
     */
    void insertVerifycode(Verifycode verifycode) throws PersistenceException;

    /**
     * 根据邮箱获最新一次验证码
     * @param email
     * @return
     * @throws PersistenceException
     */
    Verifycode getVerifycode(String email) throws PersistenceException;

    /**
     * 根据邮箱删除没用的验证码记录
     * @param email
     * @throws PersistenceException
     */
    void deleteVerifycode(String email) throws PersistenceException;
}
