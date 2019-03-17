com.xkc.learn.servlet:
	Server applet  运行在服务端的小程序
	就是一个接口, 定义了java类被浏览器访问(tomcat识别)的规则
	
1.创建javaEE项目
2.定义一个类, 实现Servlet方法
3.实现Servlet接口中的抽象方法
4.配置Servlet

执行原理:
	1.http请求, 解析url路径, 获取访问的Servlet路径
	2.查找web.xml文件, 查询对应的<url-pattern>标签内容
	3.找到<servlet-class>全类名
	4.tomcat加载对应的类到内存, 利用反射创建对象
	5.多态调用service方法
	
Servlet生命周期:
	1.init()初始化方法
		在Servlet被创建时执行, 只会执行一次
		Servlet默认被访问时创建, 也可配置服务器启动时创建
		web.xml配置: -1就是默认值, 0/正整数就是服务器启动时创建
	2.service()方法
		每一次Servlet被访问时执行, 会执行多次
	3.destroy()方法
		在Servlet销毁时执行, 服务器正常关闭, 只会执行一次
	4.getServletConfig()
		获取Servlet配置对象
	5.getServletInfo()
		获取Servlet的一些信息, 版本, 作者....
		
Servlet3.0可以使用@WebServlet("/demo3")注解配置, 不需要web.xml配置文件

Servlet体系结构
	1.GenericServlet
	2.HttpServlet