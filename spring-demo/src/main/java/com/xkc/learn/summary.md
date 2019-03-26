core:
	Spring框架核心工具, Spring其他组件都需要使用这个包, 是其他组件的核心

beans:
	所有应用都要用到, 包含配置文件, 创建和管理Bean, 进行IOC/DI操作相关的所有类
	
context:
	Spring提供在基础IoC功能上的拓展服务, 邮件服务, 任务调度, 远程访问, 缓存, 以及各种视图框架的封装

expression:
	Spring表达式语言
	
装配Bean就是在xml文件中配置Bean
 
装配Bean的三种方式:
	1.直接创建     
	2.通过静态工厂创建
    3.实例工厂方法
    
Bean的作用域:
	1.singleton   单例, 不写scope默认是单例
	2.prototype   每次调用getBean()相当于new XXXBean(), 创建新对象
	3.request     每次HTTP请求, 都会创建新的Bean
	4.session     同一个HTTP Session共享同一个Bean
	5.globalSession 
	
Bean的生命周期:
	1.instantiate: 对象实例化
	2.populate properties 封装属性
	3.如果Bean实现BeanNameAware 执行setBeanName
	4.如果Bean实现BeanFactoryAware 执行setBeanFactory, 获取Spring容器
	5.如果存在类实现BeanPostProcessor(后处理器), 执行postProcessBeforeInitialization
	6.如果Bean实现InitializingBean 执行afterPropertiesSet
	7.调用<bean init-method="init"> 指定初始化方法
	8.如果存在类实现BeanPostProcessor(处理Bean), 执行postProcessAfterInitialization 执行业务处理
	9.如果Bean实现DisposableBean 执行destroy
	10.调用<bean destroy-method="customDestroy"> 执行指定销毁方法
	
依赖注入Bean属性(手动装配):
	1.构造方法注入
	2.setter方法注入
	3.p命名空间注入(了解)
	
SpEL表达式:
	<property name="name" value="#{表达式}">
	用表达式取代固定值
	#{123} / #{'jack'}: 数字, 单引号包围的是字符串
	#{beanId}:          另一个Bean的引用
	#{beanId.proName}:  操作数据
	#{beanId.toString()}: 调用方法
	#{T(类).Field|Method}: 静态字段|方法
	
数据结构的注入:
	List
	Set
	Map
	Array
	Properties
	
注解的注入: 自动注入, 简化配置
	@Component      取代 <bean class="xx.xx.xx.xx">
	@Component(id)  取代 <bean id="xxx" class="xx.xx.xx.xx">
	@Repository(id) Dao层
	@Service(id)    service层
	@Controller(id) web层
	@Autowired:     根据类型自动注入
	@Qualifier(id)  指定自动注入的id
	@Resource(id)   根据名称自动注入, 等价于@Autowired + @Qualifier(id)
	@PostConstruct  自定义初始化
	@PreDestroy     自定义销毁
	
AOP面向切面编程:
	1.底层采用代理机制
	2.接口 + 实现类, Spring采用JDK的动态代理
	3.实现类, 采用cglib字节码增强	
	术语:
		1.target    需要被代理的类
		2.JoinPoint 连接点, 可能被拦截的方法
		3.PointCut  切入点, 已经被拦截的方法
		4.advice    通知/增强, after / before  比如开启事务和提交事务
		5.Weaving   织入, 把增强的advice应用到目标对象来创建代理对象的过程
		6.proxy     代理对象
		7.Aspect    切面, 切入点和advice的结合
		
CGLIB增强字节码:
	没有接口, 只有实现类, 采用cglib代理
	在运行时, 创建目标类的子类, 增强目标类
	
AOP联盟通知: 通知在连接点的位置
	1.前置通知
	2.后置通知
	3.环绕通知
	4.异常抛出通知
	5.引介通知   在目标类中添加新的方法和属性
	
Spring编写代理半自动:
	让Spring创建代理对象, 从Spring容器中手动获取代理对象
	依赖核心4+1  AOP联盟(一种规范)  spring-aop
	
SpringAOP全自动:
	自动生成代理对象, 指定包下的方法调用都会被拦截
	
AspectJ:
	通知类型, 只定义类型名称和方法格式
	before          前置通知, 在方法执行前执行, 通知抛出异常, 方法中断
	afterreturning  后置通知(用于常规数据处理) 方法正常返回后执行, 方法抛出异常, 通知无法执行
					必须在方法执行后才能执行, 可以获得方法的返回值
	around          环绕通知, 在方法的执行前后分别执行, 可以阻止方法的执行, 必须手动执行目标方法
	afterthrowing   抛出异常通知, 方法抛出异常后执行,  方法不抛出异常, 则无法执行 
	after           最终通知, 方法执行完毕后执行, 无论方法是否出现异常

通知的执行顺序:
	before -> around -> (afterthrowing)afterreturning -> around -> after
AspectJ切入点表达式:
	execution'(修饰符 返回值 包.类.方法名(参数) throws 异常)"
	within
	this
	target
	args
	bean
