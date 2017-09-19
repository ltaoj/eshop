package org.eshop.service;

import org.eshop.exception.VerifycodeServiceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface VerifycodeService {
    void getVerifycode(String email) throws VerifycodeServiceException;
}
