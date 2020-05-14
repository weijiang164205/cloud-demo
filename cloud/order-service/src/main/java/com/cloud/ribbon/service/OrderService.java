package com.cloud.ribbon.service;

import com.cloud.ribbon.domain.ProductOrder;

public interface OrderService {
    /**
     * 下单接口
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(int userId, int productId);
}
