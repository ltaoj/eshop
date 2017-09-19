package org.eshop.service;

import org.eshop.entity.Signon;
import org.eshop.entity.Supplier;
import org.eshop.exception.AccountServiceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface AccountService {
    /**
     * 用户注册
     * @param signon
     * @throws AccountServiceException
     */
    void registUser(Signon signon) throws AccountServiceException;

    /**
     * 供货商注册
     * @param supplier
     * @throws AccountServiceException
     */
    void registSupplier(Supplier supplier) throws AccountServiceException;
}