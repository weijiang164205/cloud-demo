package com.cloud.ribbon.service;

import com.cloud.ribbon.fallbacck.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient {
    @RequestMapping("/api/v1/product/find")
    String findById(@RequestParam(value = "id") int id);

}
