
安徽大学：
专业：2014级信息安全
学号：E41414047
姓名：赵子彰

毕业设计前端：graduation-design-express
毕业设计后端：graduation-design-java (spring + SpringMvc + maven + mybatis + SpringSecurity)

后端项目如下：
graduation-design-java：
             -- base
             -- service
             -- scheduler
             -- web(SpringMvc)
             -- api

1 base模块的定位是对数据库的增删改查和一些各模块都需要用到的工具类，常量类等
     预计将提供以下功能
     1.1 定义了后端服务返回的结果类型BaseResult,DataResult
     1.2 实现RSA签名的生成过程和验证过程
     1.3 log组件统一使用log4j2，使用@Log4j2注解自动生成log对象
     1.4 使用lombok  @Data注解自动生成java model的get/set方法
     1.5 统一用joda-time库来处理日期相关
     1.6 尽可能使用google guava来处理跟集合相关的操作

2 service模块的定位是常用的服务和封装业务逻辑的处理，供scheduler， web，api引用
     预计将提供以下功能
     2.1  邮件通知服务
     2.2  服务状态告警服务
     2.2  定义异步写数据库接口
     2.3  实现http client service

3 scheduler模块的定位 是后台定时任务
      预计将提供以下功能
      3.1  实现信号处理器，当服务停止时需监听告警
      3.2  基本的日志打印和计时功能
      3.3  规定定时器采用spring task，执行器和调度器采用线程池并自由配置参数

4 web模块的定位是web管理后台
       预计将提供以下功能
       4.1  实现用户名密码登陆，接入公司openid
       4.2  定义抽象的controller类，包含处理异常逻辑，获取当前登陆用户
       4.3  实现StartStopListener监听器监听应用程序的启动和停止，告警
       4.4  规定后端服务返回的结果类型必须是BaseResult类型

5 api模块的定位是外界与系统交互的唯一途径
      5.1 定义抽象的controller类，包含处理异常逻辑
      5.2 实现健康检查接口
      5.3 实现一个http request  to json 的拦截器
      5.4 实现一个签名认证的拦截器
      5.5 实现一个对请求参数验证的拦截器
      5.6 实现StartStopListener监听器监听应用程序的启动和停止，告警
      5.7 规定api返回的结果类型必须是BaseResult类型

模块依赖关系为：
service => base
scheduler，web，api => service
scheduler，web，api => base

这里的Service主要指服务，和Service层 Mapper层 Controller层相比说的是另一回事。。表示公共服务
