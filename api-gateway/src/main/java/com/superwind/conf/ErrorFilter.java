package com.superwind.conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Created by jiangxj on 2017/8/2.
 */
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }
    @Override
    public int filterOrder() {
        return -1;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        ctx.set("error.status_code", 100);
        ctx.set("error.exception", throwable.getCause());
        ctx.set("error.message","自定义异常消息");

        return null;
    }
}
