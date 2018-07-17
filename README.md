# Grails Rest Seed

顾名思义，这个工程是grails rest-api的模板工程，其脱胎于实际的项目经验，集合了我们Grails项目的初始工具包和插件：
- 数据库
  - postgresql-extensions
  - Hikari连接池
  - postgresql jdbc driver
  - Java 8日期类型支持：grails-java8和hibernate-java8
- 安全
  - spring-security-core
  - spring-security-rest
- Servlet容器
  - spring-boot-starter-undertow
- Migration
  - database-migration
  - liquibase-core

除此之外，工程模板还包含了相关插件必要的初始化配置和代码：
- 日志
  - 应用滚动日志。
  - 独立的SQL调试日志，需设置“DEBUG_SQL”环境变量。
- 数据库和GORM
  - 启用Hikari连接池。
  - 为Domain Class的id缺省启用PG的sequence。
  - 采用实际DB作为测试基准库，避免因测试和实际DB不一致而引发的意外。
  - 包含了一个示例类，用于展示如何使用PG的丰富类型（jsonb和数组）和java 8日期类型。并且还包括了对应的测试代码。
- 安全
  - Spring Security和Spring Security Rest配置。
  - User、Role、UserRole初始化。
  - 记录登录历史。
  - 口令加密，采用默认的“bcrypt”算法，其已经具备salt功能。

## 使用指南

  1. git clone
  1. 修改相应的包名，目前包的根为：top.dteam.earth.backend
  1. 自有发挥