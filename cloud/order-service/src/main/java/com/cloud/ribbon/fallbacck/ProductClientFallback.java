package com.cloud.ribbon.fallbacck;

import com.cloud.ribbon.service.ProductClient;
import org.springframework.stereotype.Component;
@Component
public class ProductClientFallback  implements ProductClient {
    @Override
    public String findById(int id) {
        System.out.println("feign 调用product-service findbyid 异常");
        return null;
    }
}
