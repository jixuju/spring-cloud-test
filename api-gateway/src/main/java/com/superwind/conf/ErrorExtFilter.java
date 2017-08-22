package com.superwind.conf;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * Created by jiangxj on 2017/8/3.
 */
public class ErrorExtFilter extends SendErrorFilter {
    @Override
    public String filterType() {
        return "error";
    }
    @Override
    public int filterOrder() {
        return 30;	// 大于ErrorFilter的值
    }
    @Override
    public boolean shouldFilter() {
        // TODO 判断：仅处理来自post过滤器引起的异常
        return true;
    }
}
