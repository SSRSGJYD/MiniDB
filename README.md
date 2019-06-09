# MiniDB

## 简介

MiniDB是一个轻量级的关系数据库，支持多数据库的存储，实现了基本的select、insert、delete、join等语句。

## 运行

环境：Java1.8及以上

运行方式：下载release版本的server.jar (<https://github.com/SSRSGJYD/MiniDB/releases>)，在同级目录下执行

```shell
java -jar server.jar
```

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
+ join、outer join

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

### 词法语法解析模块

使用antler4进行词法语法解析，通过继承MiniSQLBaseListener来遍历抽象语法树生成Statement

### 执行模块

执行Statement，对数据库进行各种操作

### client模块

图形界面客户端基于JavaFX框架，利用HttpClient和httpasyncclient实现http异步通信。

### server模块

服务端基于JDK内置的com.sun.net.httpserver包，利用HttpServer、HttpContext、HttpHandler和HttpExchange实现了HTTPS服务，处理HTTPS请求。

由于HttpExchange没有参数解析的功能，因此，需要实现类ParameterFilter和方法parseQuery来解析GET、POST请求的参数。



## 亮点

+ B+树和缓存机制实现高效的存储
+ 可以创建或删除数据库实例，可以在数据库实例中切换
+ 数据库级别的用户权限
+ where子句的条件支持and和or
+ 支持outer join操作
+ 支持三张表以上的join



## 性能测试

#### 测试环境

操作系统: 4.19.45-1-MANJARO

CPU: Intel Core i7-8565U

内存: 7863M

以下测试比较了HSQLDB与3种MiniDB实现在脚本上的执行时间，其中no cache代表不使用缓存的版本，cache 1000代表最大缓存数为1000个内部节点+1000个叶节点的版本，async cache代表使用异步写文件的版本。

（注：以下文件名中的‘xxxx’代表测试的数据规模，即1000或10000）

#### insert测试

- hsqldb的测试：手动创建play表：

```sql
create table play(id int, name int, primary key(id))
```

之后点击open script导入insert_xxxx.script脚本并执行

- minidb的测试：删除原有的数据库文件，之后执行脚本insert_xxxx.script

| scale | hsqldb  | minidb(no cache) | minidb(cache 1000) | minidb(async cache) |
| ----- | ------- | ---------------- | ------------------ | ------------------- |
| 1000  | 70.9ms  | 617.253435ms     | 525.376677ms       | 383.804395ms        |
| 10000 | 165.6ms | 42138.957818ms   | 4280.601352ms      |  431.905812ms      |

#### select测试

- hsqldb的测试：在insert测试的基础上，点击open script导入select_xxxx.script脚本并执行
- minidb的测试：在insert测试的基础上，执行脚本select_xxxx.script进行测试

| type | scale | hsqldb | minidb(no cache) | minidb(cache 1000) | minidb(async cache) |
| ---- | ----- | ------ | ---------------- | ------------------ | ------------------- |
| pk   | 1000  | 0.4ms  | 11.743167 ms     | 12.033778ms        | 17.192940ms         |
| pk   | 10000 | 0.8ms  | 74.171247ms      | 74.694115ms        | 54.384821ms`        |
| sk   | 1000  | 0.6ms  | 83.751510 ms     | 26.623606ms        | 58.101084ms         |
| sk   | 10000 | 6.0ms  | 3586.476549ms    | 219.747083ms       | 107.471312ms         |

join测试

- hsqldb：在select测试的基础上，手动创建play2表

```sql
create table play2(id int, age int, primary key(id))
```

之后点击open script导入hsql_join_init_xxxx.script脚本进行初始化，最后导入join.script进行测试

- minidb：在select测试的基础上，执行join_init_xxxx.script脚本进行初始化，然后执行join.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1000) | minidb(async cache) |
| ----- | ------ | ---------------- | ------------------ | ------------------- |
| 1000  | 2.7ms  | 83.861124ms      | 25.022497ms        | 45.308601ms         |
| 10000 | 15.1ms | 4067.273535ms    | 143.270791ms       | 148.557085ms         |

#### delete测试

- hsqldb：点击open script导入delete_xxxx.script脚本并执行
- minidb：执行脚本delete_xxxx.script进行测试

| scale | hsqldb   | minidb(no cache) | minidb(cache 1000) | minidb(async cache) |
| ----- | -------- | ---------------- | ------------------ | ------------------- |
| 1000  | 33.9ms   | 908.504563 ms    | 607.182396ms       | 274.146806ms        |
| 10000 | 1588.4ms | 8961.646596ms    | 3275.003313ms      | 685.172844ms        |


