package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements IMemberService {
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setAge(20);
        return user;
    }
}

