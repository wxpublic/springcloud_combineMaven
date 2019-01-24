# springcloud_combineMaven
一个Maven聚合项目的演练，内容包括一个Eureka注册中心，还有一个Maven三层聚合项目

主要内容有：

Hystrix服务降级注解实现服务降级，代码摘要：@HystrixCommand(fallbackMethod = "hystrixFallBack")

Feign客户端使用（自带ribbon负载均衡器），一些必须的参数配置；

演示熔断器Hystrix注解说明; 一个注解@HystrixCommand自动实现服务降级、线程隔离、服务熔断；解决服务的雪崩效应，

Hystrix有两种保护服务的实现方式：注解和接口形式;本项目演示注解模式

fallbackMethod 作用：服务降级执行的方法

@HystrixCommand 此注解默认自动开启：
                
                服务隔离：线程池方式,不同服务有自己单独线程池；某服务死掉不会影响其他服务请求。
                
                服务降级：服务降级执行方法：hystrixFallBack
                
                服务熔断

一个注解三大功能全搞定，堪称优秀

使用Hystrix需要设置服务调用超时时间，这个和ribbon全局超时是两码事；默认超时也是1秒，可以设大一点，也可以直接设置关闭超时异常提示开关；

项目其他功能：Feign客户端使用（自带ribbon负载均衡器），一些必须的参数配置；
