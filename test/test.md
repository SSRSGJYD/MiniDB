### Minidb性能测试



#### 测试环境

操作系统: 4.19.45-1-MANJARO

CPU: Intel Core i7-8565U

内存: 7863M



注：改变缓存使用的方法：在BPlusTree.java文件中的B+树的构造函数中，改变useCache属性的真假值选择是否使用缓存。

注：以下文件名中的‘xxxx’代表测试的数据规模，即1000或10000。

#### insert测试

+ hsqldb的测试：手动创建play表：

```sql
create table play(id int, name int, primary key(id))
```

之后点击open script导入insert_xxxx.script脚本并执行

+ minidb的测试：删除原有的数据库文件，之后执行脚本insert_xxxx.script

| scale | hsqldb | minidb(no cache) | minidb(cache 1000) |minidb(async cache)|
| ----- | ------ | ---------------- | ------------------ |  ------------------ |
| 1000  |   70.9ms  |      617.253435ms           |   525.376677ms            | 354.878979ms|
| 10000 |   165.6ms     |     42138.957818ms             |      4280.601352ms   |    941.955378ms       |



#### select测试

- hsqldb的测试：在insert测试的基础上，点击open script导入select_xxxx.script脚本并执行
- minidb的测试：在insert测试的基础上，执行脚本select_xxxx.script进行测试

|type| scale | hsqldb | minidb(no cache) | minidb(cache 1000) |minidb(async cache)|
|-----| ----- | ------ | ---------------- | ------------------ |------------------ |
|pk | 1000 |   0.4ms  |     11.743167 ms        |        12.033778ms            | 55.216255ms |
|pk| 10000 | 0.8ms  |   74.171247ms        |        74.694115ms   | 22.007795ms`         |
|sk | 1000 |  0.6ms     |  83.751510 ms            |    26.623606ms     |   56.070855ms         |
|sk| 10000 | 6.0ms  |        3586.476549ms          |     219.747083ms   |   29.427447ms         |



#### join测试

+ hsqldb：在select测试的基础上，手动创建play2表

```sql
create table play2(id int, age int, primary key(id))
```

之后点击open script导入hsql_join_init_xxxx.script脚本进行初始化，最后导入join.script进行测试

+ minidb：在select测试的基础上，执行join_init_xxxx.script脚本进行初始化，然后执行join.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1000) |minidb(async cache)|
| ----- | ------ | ---------------- | ------------------ |------------------ |
| 1000  |   2.7ms     |    83.861124ms              |      25.022497ms    |  41.140142ms        |
| 10000 |   15.1ms     |   4067.273535ms               |       143.270791ms |   32.289638ms         |



#### delete测试

+ hsqldb：点击open script导入delete_xxxx.script脚本并执行
+ minidb：执行脚本delete_xxxx.script进行测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1000) |minidb(async cache)|
| ----- | ------ | ---------------- | ------------------ |------------------ |
| 1000  |   33.9ms     |      908.504563 ms            |      607.182396ms   | 412.800708ms           |
| 10000 |  1588.4ms      |        8961.646596ms          |      3275.003313ms |     737.548812ms        |

