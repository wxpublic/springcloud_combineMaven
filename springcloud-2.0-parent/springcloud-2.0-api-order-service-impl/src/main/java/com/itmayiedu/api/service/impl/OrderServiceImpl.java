package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IOrderService;
import com.itmayiedu.api.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    @RequestMapping("/orderToMember")
    public String orderToMember(String name){
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity==null?"没有找到用户信息":userEntity.toString();
    }
}
