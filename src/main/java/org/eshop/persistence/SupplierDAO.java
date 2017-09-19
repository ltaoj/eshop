package org.eshop.persistence;

import org.eshop.entity.Supplier;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface SupplierDAO {
    /**
     * 插入供货商信息
     * @param supplier
     * @throws PersistenceException
     */
    void insertSupplier(Supplier supplier) throws PersistenceException;

    /**
     * 修改供货商信息
     * @param supplier
     * @throws PersistenceException
     */
    void updateSupplier(Supplier supplier) throws PersistenceException;
}
