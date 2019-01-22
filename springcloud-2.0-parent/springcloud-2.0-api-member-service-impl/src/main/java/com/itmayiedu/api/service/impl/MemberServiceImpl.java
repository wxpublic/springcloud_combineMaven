package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IMemberService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setAge(20);
        return user;
    }

    @RequestMapping("/getMemberGroup")
    public String getMemberGroup(){
        return "我是会员服务，噗哈哈哈哈哈！看我给你变个端口魔术："+serverPort;
    }

    @RequestMapping("/getMemberUserInfo")
    public ResponseBase getMemberUserInfo(){
        try {
            //延迟1.5秒返回。
            Thread.sleep(1500);
            System.out.println("会员服务方法:getMemberUserInfo()");
        }catch(Exception e){
        }
        return setResultSuccess("我是会员服务");
    }

}

