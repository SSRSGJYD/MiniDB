### 性能测试



#### 测试环境



#### insert测试

+ 
+ minidb的测试：删除原有的数据库文件，在B+树的构造函数中通过改变useCache属性的真假值选择是否使用缓存，之后执行脚本insert_xxxx.script

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |



#### select测试

| scale | hsqldb | minidb(no cache) | minidb(cache 1024) |
| ----- | ------ | ---------------- | ------------------ |
| 1000  |        |                  |                    |
| 10000 |        |                  |                    |

