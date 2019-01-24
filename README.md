# springcloud_combineMaven
一个Maven聚合项目的演练，内容包括一个Eureka注册中心，还有一个Maven三层聚合项目

主要内容有：

Hystrix服务降级注解实现服务降级，代码摘要：@HystrixCommand(fallbackMethod = "hystrixFallBack")

Feign客户端使用（自带ribbon负载均衡器），一些必须的参数配置；
