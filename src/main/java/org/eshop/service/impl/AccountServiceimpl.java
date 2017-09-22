package org.eshop.service.impl;

import org.eshop.entity.Signon;
import org.eshop.entity.Supplier;
import org.eshop.entity.Userinfo;
import org.eshop.exception.AccountServiceException;
import org.eshop.persistence.SignonDAO;
import org.eshop.persistence.SupplierDAO;
import org.eshop.persistence.UserinfoDAO;
import org.eshop.service.AccountService;
import org.eshop.util.ObjectTransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Service
public class AccountServiceimpl implements AccountService {

    private UserinfoDAO userinfoDAO;
    private SignonDAO signonDAO;
    private SupplierDAO supplierDAO;

    @Autowired
    public AccountServiceimpl(UserinfoDAO userinfoDAO, SignonDAO signonDAO, SupplierDAO supplierDAO) {
        this.userinfoDAO = userinfoDAO;
        this.signonDAO = signonDAO;
        this.supplierDAO = supplierDAO;
    }

    public void registUser(Signon signon) throws AccountServiceException {
        userinfoDAO.insertUserinfo(ObjectTransformUtil.toUserinfo(signon));
        signon.setAuthorities("ROLE_USER");
        signonDAO.insertSignon(signon);
    }

    public void registSupplier(Supplier supplier) throws AccountServiceException {

    }

    public Userinfo getUser(String loginId) throws AccountServiceException {
        return userinfoDAO.getUserinfo(loginId);
    }
}
