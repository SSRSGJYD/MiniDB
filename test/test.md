### Minidb性能测试



#### 测试环境

操作系统：

CPU:

内存：



注：改变缓存使用的方法：在BPlusTree.java文件中的B+树的构造函数中，改变useCache属性的真假值选择是否使用缓存。

注：以下文件名中的‘xxxx’代表测试的数据规模，即1000或10000。

#### insert测试

+ hsqldb的测试：手动创建play表：

```sql
create table play(id int, name int, primary key(id))
```

之后点击open script导入insert_xxxx.script脚本并执行

+ minidb的测试：删除原有的数据库文件，之后执行脚本insert_xxxx.script

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |



#### select测试

- hsqldb的测试：在insert测试的基础上，点击open script导入select_xxxx.script脚本并执行
- minidb的测试：在insert测试的基础上，执行脚本select_xxxx.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |



#### join测试

+ hsqldb：在select测试的基础上，手动创建play2表

```sql
create table play2(id int, age int, primary key(id))
```

之后点击open script导入hsql_join_init_xxxx.script脚本进行初始化，最后导入join.script进行测试

+ minidb：在select测试的基础上，执行join_init_xxxx.script脚本进行初始化，然后执行join.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |



#### delete测试

+ hsqldb：点击open script导入delete_xxxx.script脚本并执行
+ minidb：执行脚本delete_xxxx.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |

