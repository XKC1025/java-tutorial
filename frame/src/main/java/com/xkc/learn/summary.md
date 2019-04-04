1.MyBatis框架核心:
	Mybatis全局配置文件: 数据源, 事务等信息
	Mybatis映射文件:     SQL相关的信息
	
2.MyBatis读取配置文件信息(全局配置文件&映射文件), 构造出SqlSessionFactory

3.通过会话工厂, 创建SqlSession会话, MyBatis通过SqlSession来操作数据库

4.SqlSession不能直接操作数据库, 通过底层的Executor执行器接口来操作

5.Executor两个实现类, 一个是普通执行器, 另一个是缓存执行器(默认)

6.Executor执行器将要处理的SQL信息封装到一个底层对象MappedStatement中, 包括SQL语句, 输入参数映射信息, 输出结果集映射信息
  输入参数和输出结果映射类型包括: java简单数据类型, HashMap集合对象, POJO对象类型