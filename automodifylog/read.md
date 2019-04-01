# Getting Started

### Guides
springboot 2.x 后提供了 0代码实现 动态控制日志级别输出
本案例：http://localhost:8080/actuator/loggers   查看当前日志级别
查看摸一个指定包的日志几倍：http://localhost:8080/actuator/loggers/包名
动态修改日志级别操作：http://localhost:8080/actuator/loggers/包名      post请求 请求体 {"configuredLevel":"debug"}