package org.eshop.service;

import org.eshop.entity.Harvestaddr;
import org.eshop.entity.Signon;
import org.eshop.entity.Supplier;
import org.eshop.entity.Userinfo;
import org.eshop.exception.AccountServiceException;
import org.hsqldb.rights.User;

import javax.persistence.PersistenceException;
import java.util.List;

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
     * 获取登录信息
     * @param userId
     * @return
     * @throws AccountServiceException
     */
    Signon getSignon(String userId) throws AccountServiceException;

    /**
     * 修改密码
     * @param loginId
     * @param password
     * @throws AccountServiceException
     */
    void changePassword(String loginId, String password) throws AccountServiceException;

    /**
     * 修改用户信息
     * @param userinfo
     * @throws AccountServiceException
     */
    void updateUserInfo(Userinfo userinfo) throws AccountServiceException;

    /**
     * 供货商注册
     * @param supplier
     * @throws AccountServiceException
     */
    void registSupplier(Supplier supplier) throws AccountServiceException;

    /**
     * 获取用户基本信息
     * @param loginId
     * @return
     * @throws AccountServiceException
     */
    Userinfo getUser(String loginId) throws AccountServiceException;

    /**
     * 获取收获地址
     * @param loginId
     * @return
     * @throws AccountServiceException
     */
    List<Harvestaddr> getHarvestAddr(String loginId) throws AccountServiceException;

    /**
     * 添加收获地址
     * @param harvestaddr
     * @throws AccountServiceException
     */
    void addHarvestAddr(Harvestaddr harvestaddr) throws AccountServiceException;

    /**
     * 删除收货地址
     * @param addrId
     * @throws AccountServiceException
     */
    void deleteHarvestAddr(int addrId) throws AccountServiceException;

    /**
     * 修改收货地址信息
     * @param harvestaddr
     * @throws AccountServiceException
     */
    void updateHarvestAddr(Harvestaddr harvestaddr) throws AccountServiceException;

    /**
     * 设置默认收货地址
     * @param addrId
     * @param loginId
     * @throws AccountServiceException
     */
    void setDefaultAddr(int addrId, String loginId) throws AccountServiceException;
}
