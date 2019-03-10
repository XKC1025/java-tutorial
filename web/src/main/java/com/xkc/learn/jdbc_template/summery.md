Spring JDBC:
	Spring框架对JDBC的简单封装, 提供 JDBCTemplate简化JDBC开发
	
基本步骤:
	1.创建JdbcTemplate对象, 依赖于数据源DataSource
	2.调用JdbcTemplate方法完成CRUD
	update(): 执行DML语句
	queryForMap():   查询结果封装成map集合
	queryForList():  查询结果封装为list集合
	query():         结果封装为JavaBean对象
	queryForObject(): 结果封装成对象