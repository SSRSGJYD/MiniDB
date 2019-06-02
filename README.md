# MiniDB



## 简介

MiniDB是一个轻量级的关系数据库，支持多数据库的存储，实现了基本的select、insert、delete、join等语句。



## 功能

### 数据库操作

+ create database
+ drop database
+ use database
+ show databases
+ show database dbName

### 表操作

+ create
+ drop
+ insert
+ delete
+ select

### 权限管理

+ create user
+ grant select on table to user [with grant option]
+ grant update on table to user [with grant option]
+ revoke select on table from user
+ revoke update on table from user


### 图形界面客户端

+ 登录
+ 查看数据库、表、属性信息
+ 读取sql文件，保存sql文件
+ 显示查询结果、执行时间
+ 保存查询结果到文件
+ 从文件中直接读取sql语句并执行（import操作）

### 服务端

* 构建MiniDB
* 启动服务器，监听本地8080端口
* 解析GET、POST请求参数
* 处理登录请求
* 处理sql请求



## 实现

### 总体架构

系统分为以下主要模块：

+ 存储、索引模块：管理数据、索引与元数据的存储
+ 词法语法解析模块：分析输入的语句，构造出语法树
+ 执行模块：执行语法树
+ server模块：监听端口，调用执行模块，将结果返回client
+ client模块：图形界面客户端，通过http与server进行通信



### 存储、索引模块

数据库支持在单一属性上的Primary Index和Secondary Index，其中Secondary Index中查询到的数据是主键。所有的数据和索引都采用B+树进行存储管理，数据直接存储在主键索引的叶节点中。

为了提高性能，对B+树的内部节点和叶节点进行缓存，采用**LRU**策略。另外，在slot节点链表中存储空页的位置，避免文件中空间浪费。



### client模块

图形界面客户端基于JavaFX框架，利用HttpClient和httpasyncclient实现http异步通信。



### server模块

服务端基于JDK内置的com.sun.net.httpserver包，利用HttpServer、HttpContext、HttpHandler和HttpExchange实现了HTTPS服务，处理HTTPS请求。

由于HttpExchange没有参数解析的功能，因此，需要实现类ParameterFilter和方法parseQuery来解析GET、POST请求的参数。



## 亮点

+ B+树+缓存机制实现高效的存储
+ 可以创建或删除数据库实例，可以在数据库实例中切换
+ 数据库级别的用户权限
+ where子句的条件支持and和or
+ 支持outer join操作
+ 支持三张表以上的join



## 组内分工

苏乐：

周展平：B+树索引、client

周泽龙：server