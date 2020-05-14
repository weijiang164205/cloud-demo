package com.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class ZuulFilterCustomer extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1; //在pre之前执行 数字越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        //返回true表示拦截 返回false 则不是拦截
        //在这里根据 获取请求的链接进行判断是否进行拦截
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //在这个地方处理拦截的逻辑
        RequestContext currentContext = RequestContext.getCurrentContext();

        //获取到request 就可以获取到请求的一些信息然后进行逻辑处理
        HttpServletRequest request = currentContext.getRequest();

        //TODO 一些处理
        return null;
    }
}
