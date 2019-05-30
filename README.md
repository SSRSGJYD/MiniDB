### MiniDB



#### 简介

MiniDB是一个轻量级的关系数据库，支持多数据库的存储，实现了基本的select、insert、delete、join等语句。



#### 功能

##### 数据库操作

+ create database
+ drop database
+ use database
+ show database



##### 表操作

+ create
+ drop
+ insert
+ delete
+ select



##### 权限管理





#### 实现

##### 总体架构

系统分为以下主要模块：

+ 存储、索引模块：管理数据、索引与元数据的存储
+ 词法语法解析模块：分析输入的语句，构造出语法树
+ 执行模块：执行语法树
+ server模块：监听端口，调用执行模块，将结果返回client
+ client模块：图形界面客户端，通过http与server进行通信



done: 
- dynamic syntax error check
- where子句的and or
- outer join
