package com.itmayiedu.api.feign;

import com.itmayiedu.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-itmayiedu-member")
public interface MemberServiceFeign extends IMemberService {
    //订单服务集成会员服务接口，用来实现Feign客户端减少重复接口代码
}
