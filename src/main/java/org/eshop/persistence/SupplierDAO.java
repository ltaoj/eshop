package org.eshop.persistence;

import org.eshop.entity.Supplier;

import javax.persistence.PersistenceException;
import java.util.List;

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

    /**
     * 获取供货商信息
     * @param supplierId
     * @return
     * @throws PersistenceException
     */
    Supplier getSupplier(String supplierId) throws PersistenceException;

    /**
     * 获取所有供货商信息
     * @return
     * @throws PersistenceException
     */
    List<Supplier> getSupplierList() throws PersistenceException;
}
