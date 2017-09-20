package org.eshop.persistence;

import org.eshop.entity.Lineitem;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface LineitemDAO {
    /**
     * 添加订单商品列表
     * @param lineitemList
     * @throws PersistenceException
     */
    void insertLineitemList(List<Lineitem> lineitemList) throws PersistenceException;

    /**
     * 删除订单商品列表
     * @param orderId
     * @throws PersistenceException
     */
    void deleteLineitemByOrderId(String orderId) throws PersistenceException;

    /**
     * 获取订单商品列表
     * @param orderId
     * @return
     * @throws PersistenceException
     */
    List<Lineitem> getLineitemListByOrderId(String orderId) throws PersistenceException;
}
