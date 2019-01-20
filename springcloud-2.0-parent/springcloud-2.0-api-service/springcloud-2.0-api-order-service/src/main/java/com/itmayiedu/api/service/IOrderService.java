package com.itmayiedu.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {
    /**
     * 订单调用会员服务，feign客户端
     */
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);
}
