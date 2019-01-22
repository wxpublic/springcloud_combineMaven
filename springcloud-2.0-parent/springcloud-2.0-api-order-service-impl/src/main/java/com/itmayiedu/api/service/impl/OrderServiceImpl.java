package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IOrderService;
import com.itmayiedu.api.feign.MemberServiceFeign;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService{
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    /**
     * 注意：此方法调用需要带参数
     */
    @RequestMapping("/orderToMember")
    public String orderToMember(String name){
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity==null?"没有找到用户信息":userEntity.toString();
    }

    /**
     * 演示集群会员服务端口变换效果
     */
    @RequestMapping("/orderToMemberDiffPort")
    public String orderToMemberDiffPort() {
        return memberServiceFeign.getMemberGroup();
    }

    /**
     * 演示超过默认一秒后，系统报超时异常，此时在配置文件设置全局模式的ribbon访问超时属性：
     * ribbon.ReadTimeout 和 ribbon.ConnectTimeout
     */
    @RequestMapping("/getOrderUserInfo")
    public ResponseBase getOrderUserInfo(){
        return memberServiceFeign.getMemberUserInfo();
    }

    /**
     * 演示熔断器Hystrix; 一个注解@HystrixCommand自动实现服务降级、线程隔离、服务熔断；解决服务的雪崩效应
     * Hystrix有两种保护服务的实现方式：注解和接口形式;本项目演示注解模式
     * fallbackMethod 作用：服务降级执行的方法
     * @HystrixCommand 此注解默认自动开启：
     *                 服务隔离：线程池方式,不同服务有自己单独线程池；某服务死掉不会影响其他服务请求。
     *                 服务降级：服务降级执行方法：hystrixFallBack
     *                 服务熔断
     * 一个注解三大功能全搞定，真TM优秀
     * 使用Hystrix需要设置服务调用超时时间，这个和ribbon全局超时是两码事；
     * 默认超时也是1秒，可以设大一点，也可以直接设置关闭超时异常提示开关；
     */
    @HystrixCommand(fallbackMethod = "hystrixFallBack")
    @RequestMapping("/orderHystrix")
    public ResponseBase orderHystrix() {
        System.out.println("orderHystrix方法线程名称:"+Thread.currentThread().getName());
        ResponseBase ret = memberServiceFeign.getMemberUserInfo();
        System.out.println("orderHystrix方法返回:"+ret.getMsg());
        return ret;
    }

    /**
     * 服务降级所执行的方法，fallback对应方法
     */
    public ResponseBase hystrixFallBack(){
        return setResultSuccess("我是订单服务，我被攻击了，临时采用了服务降级，Server Service Busy，Please try again later..");
    }

    /**
     * 本方法用意；配合熔断方法orderHystrix，测试不同服务请求默认采用线程池隔离;线程名不一样；
     */
    @RequestMapping("/testOrderInfo")
    public ResponseBase testOrderInfo() {
        System.out.println("testOrderInfo方法线程名称:"+Thread.currentThread().getName());
        return setResultSuccess();
    }
}
