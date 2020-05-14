package com.cloud.ribbon.service.impl;

import com.cloud.ribbon.domain.ProductOrder;
import com.cloud.ribbon.service.OrderService;
import com.cloud.ribbon.service.ProductClient;
import com.cloud.ribbon.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;
    @Override
    public ProductOrder save(int userId, int productId) {
        /*Object obj = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Object.class);
        System.out.println(obj);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());*/
        if(userId == 1){
            return null;
        }
        String response = productClient.findById(productId);

        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }
}
