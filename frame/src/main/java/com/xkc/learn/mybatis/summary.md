1.MyBatis框架核心:
	Mybatis全局配置文件: 数据源, 事务等信息
	Mybatis映射文件:     SQL相关的信息
	
2.MyBatis读取配置文件信息(全局配置文件&映射文件), 构造出SqlSessionFactory

3.通过会话工厂, 创建SqlSession会话, MyBatis通过SqlSession来操作数据库

4.SqlSession不能直接操作数据库, 通过底层的Executor执行器接口来操作

5.Executor两个实现类, 一个是普通执行器, 另一个是缓存执行器(默认)

6.Executor执行器将要处理的SQL信息封装到一个底层对象MappedStatement中, 包括SQL语句, 输入参数映射信息, 输出结果集映射信息
  输入参数和输出结果映射类型包括: java简单数据类型, HashMap集合对象, POJO对象类型
  
一级缓存和二级缓存:
	1.一级缓存默认开启, 指的是sqlSession.  在sqlSession中有一个数据区域, 是Map结构, key由sql语句,
	条件, statement等信息组成的唯一值, value就是查询出的结果对象
	2.二级缓存默认关闭, 指的是同一个namespace下的mapper. 二级缓存也是一个Map结构, 用的就是一级缓存的Map对象
	
不同的Session之间一级缓存不同, 但是二级缓存是共享的

执行DML操作, 会清空一级和二级缓存

由于二级缓存是永久缓存, 只要不执行DML和关闭服务器, 缓存会一直存在, 有可能会影响服务器性能

二级缓存应用场景:
	对响应速度要求高, 但实时性不高, 要设置刷新时间间隔