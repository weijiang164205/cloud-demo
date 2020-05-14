package com.cloud.ribbon.controller;

import com.cloud.ribbon.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id") int productId){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("data", orderService.save(userId, productId));
        return  data;
    }
    private Object saveOrderFail(int userId, int productId){
        //监控报警
        String saveOrderKye = "save-order";
        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;
    }

}
