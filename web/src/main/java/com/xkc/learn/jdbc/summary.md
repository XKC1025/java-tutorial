JDBC:
	Java Database Connectivity  java连接&操作数据库
	
本质:
	Java定义了一套操作所有关系型数据库的规则(接口), 各数据库公司提供实现类(驱动), 利用多态调用
	
步骤:
	1.导入驱动
	2.注册驱动
	3.获取数据库连接对象 Connection
	4.定义SQL
	5.获取执行SQL语句的对象
	6.执行SQL, 获取返回结果
	7.处理结果
	8.释放资源
	
详解各个对象:
	1.DriverManager     驱动管理对象: 注册驱动 & 获取数据库连接对象
	2.Connection        数据库连接对象: 获取执行SQL对象 & 管理事务(开启事务、提交事务、回滚事务)
	3.Statement         执行SQL对象, SQL语句参数都是给定值
						statement.execute() 执行任意SQL语句
						statement.executeUpdate()执行UPDATE、DELETE、INSERT语句
						statement.executeQuery()执行SELECT语句, 并返回ResultSet结果集对象
	4.ResultSet         结果集对象
	5.PreparedStatement 执行SQL对象, 预编译SQL, SQL语句参数都是不固定的  动态SQL
						可以解决SQL注入问题