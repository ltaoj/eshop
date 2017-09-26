package org.eshop.service.impl;

import org.eshop.entity.Harvestaddr;
import org.eshop.entity.Signon;
import org.eshop.entity.Supplier;
import org.eshop.entity.Userinfo;
import org.eshop.exception.AccountServiceException;
import org.eshop.persistence.HarvestaddrDAO;
import org.eshop.persistence.SignonDAO;
import org.eshop.persistence.SupplierDAO;
import org.eshop.persistence.UserinfoDAO;
import org.eshop.service.AccountService;
import org.eshop.util.ObjectTransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Service
public class AccountServiceimpl implements AccountService {

    private UserinfoDAO userinfoDAO;
    private SignonDAO signonDAO;
    private SupplierDAO supplierDAO;
    private HarvestaddrDAO harvestaddrDAO;

    @Autowired
    public AccountServiceimpl(UserinfoDAO userinfoDAO, SignonDAO signonDAO, SupplierDAO supplierDAO, HarvestaddrDAO harvestaddrDAO) {
        this.userinfoDAO = userinfoDAO;
        this.signonDAO = signonDAO;
        this.supplierDAO = supplierDAO;
        this.harvestaddrDAO = harvestaddrDAO;
    }

    public void registUser(Signon signon) throws AccountServiceException {
        try {
            userinfoDAO.insertUserinfo(ObjectTransformUtil.toUserinfo(signon));
            signon.setAuthorities("ROLE_USER");
            signonDAO.insertSignon(signon);
        } catch (PersistenceException e) {
            throw new AccountServiceException(e);
        }
    }

    public Signon getSignon(String userId) throws AccountServiceException {
        return signonDAO.getSignon(userId);
    }

    public void changePassword(String loginId, String password) throws AccountServiceException {
        signonDAO.changePassword(loginId, password);
    }

    public void updateUserInfo(Userinfo userinfo) throws AccountServiceException {
        userinfoDAO.changePhone(userinfo.getLoginId(), userinfo.getPhone());
        userinfoDAO.changeEmail(userinfo.getLoginId(), userinfo.getEmail());
        userinfoDAO.changeBasic(userinfo);
        signonDAO.changePhone(userinfo.getLoginId(), userinfo.getPhone());
        signonDAO.changeEmail(userinfo.getLoginId(), userinfo.getEmail());
    }

    public void registSupplier(Supplier supplier) throws AccountServiceException {
        supplierDAO.insertSupplier(supplier);
    }

    public List<Supplier> getSupplierList() throws AccountServiceException {
        return supplierDAO.getSupplierList();
    }

    public Userinfo getUser(String loginId) throws AccountServiceException {
        return userinfoDAO.getUserinfo(loginId);
    }

    public List<Harvestaddr> getHarvestAddr(String loginId) throws AccountServiceException {
        return harvestaddrDAO.getHarvestAddr(loginId);
    }

    public void addHarvestAddr(Harvestaddr harvestaddr) throws AccountServiceException {
        harvestaddrDAO.insertHarvestaddr(harvestaddr);
    }

    public void deleteHarvestAddr(int addrId) throws AccountServiceException {
        harvestaddrDAO.deleteHarvestaddr(addrId);
    }

    public void updateHarvestAddr(Harvestaddr harvestaddr) throws AccountServiceException {
        harvestaddrDAO.updateHarvestaddr(harvestaddr);
    }

    public void setDefaultAddr(int addrId, String loginId) throws AccountServiceException {
        harvestaddrDAO.setDefaultHarvestaddr(addrId, loginId);
    }
}
