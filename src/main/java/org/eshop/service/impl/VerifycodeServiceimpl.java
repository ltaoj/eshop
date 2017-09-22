package org.eshop.service.impl;

import org.eshop.entity.Verifycode;
import org.eshop.exception.VerifycodeServiceException;
import org.eshop.persistence.VerifycodeDAO;
import org.eshop.service.VerifycodeService;
import org.eshop.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ltaoj on 2017/9/18.
 */
@Service
public class VerifycodeServiceimpl implements VerifycodeService {

    private VerifycodeDAO verifycodeDAO;

    @Autowired
    public VerifycodeServiceimpl(VerifycodeDAO verifycodeDAO) {
        this.verifycodeDAO = verifycodeDAO;
    }

    public String getRandomCode() throws VerifycodeServiceException {
        return StringUtil.getRandomString(6);
    }

    public void insertVerifyCode(Verifycode verifycode) throws VerifycodeServiceException {
        verifycodeDAO.deleteVerifycode(verifycode.getEmail());
        verifycodeDAO.insertVerifycode(verifycode);
    }

    public boolean isVerifycodeValid(String email, String code) throws VerifycodeServiceException {
        return verifycodeDAO.getVerifycode(email).getCode().equals(code);
    }
}
