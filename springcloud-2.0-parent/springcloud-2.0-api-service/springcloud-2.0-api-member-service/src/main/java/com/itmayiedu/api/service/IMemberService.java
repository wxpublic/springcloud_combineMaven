package com.itmayiedu.api.service;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IMemberService{
    /**
     * 实体类应该放在接口项目还是放在接口实现项目中？
     * 回答：都不是，一般正常情况下实体类是一个独立项目，类似依赖到其他需要的项目；但是本例我们建议放在接口项目；
     * 实体类和接口都应存放在接口项目；
     * 代码的实现逻辑都应存放在实现项目中；
     */
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name);

    @RequestMapping("/getMemberGroup")
    public String getMemberGroup();

    @RequestMapping("/getMemberUserInfo")
    public ResponseBase getMemberUserInfo();
}
