A Spring MVC with Maven Multi-Module and Spring Security （draft）
========================

[![Build Status](https://travis-ci.org/aliceeee/multimodule-website-demo.svg?branch=master)](https://travis-ci.org/aliceeee/multimodule-website-demo)

# 环境

demo项目，使用HSQL作为数据库，jetty做为web服务器

# 文件结构
project
```
multimodule-website-demo
  |- account

  |    |- account-service

  |    \- account-web（war）

  |- cart

  |    |- cart-service

  |    \- cart-web（war）

  |- ...

  |- web-total（war）

  \- core（jar）
```

# Maven多模块

- 继承
即pom文件中用<parent/>。见上


- 依赖
即pom文件中用<dependency/>引入

```
multimodule-website-demo
  |- account

  |    |- account-service (core)

  |    \- account-web（account-service）

  |- cart

  |    |- cart-service (core)

  |    \- cart-web（cart-service）

  |- ...

  |- web-total（account-service, cart-service）

  \- core
```

- TODO
Dependency Management 进一步优化

- 问题
所有web项目的依赖是否需要独立写一个项目pom来管理

# Spring Context
web-total 使用maven-war-plugin插件来依赖其他war（如这里的account-web和cart-web）。
插件会把依赖的war的内容合并，合并是排除其他项目的以下文件，并以web-total的配置文件为最优先
```
WEB-INF/web.xml,index.*,WEB-INF/spring/root-context.xml
```

如下

```
account-web
...WEB-INF
     |- spring
     |    |- appServlet
     |    |    |- servlet-context-account-web.xml
     |    |- root-context.xml
     |    |- sprint-hsqldb.xml (any db connection)
     \    \- spring-security.xml
...web.xml     
cart-web
...WEB-INF
     |- spring
     |    |- appServlet
     |    |    |- servlet-context-cart-web.xml
     |    |- root-context.xml
     \    \- sprint-hsqldb.xml (any db connection)
...web.xml
web-total
...WEB-INF
     |- spring
     |    |- appServlet
     |    |    |- servlet-context.xml (web-total's)
     |    |    |- servlet-context-account-web.xml (generated by maven when packaging)
     |    |    |- servlet-context-cart-web.xml (generated by maven when packaging)
     |    |- root-context.xml (web-total's)
     |    |- spring-security.xml
     \    \- sprint-hsqldb.xml (web-total's)
...web.xml
```

其中
1.每个项目有自己的数据库连接是为了项目开发时可以单独部署
2.servlet-context-*配置各个项目自己需要的东西，最后在web-total中同时生效（如何避免冲突？制订命名规范）

# 单元测试
TODO


# 运行项目
在项目目录下运行
```
mvn clean install
```
进入web-total， 运行
```
mvn jetty:run
```

