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
	@Qualifier(id)  指定自动注入的id, 等价于@Autowired + @Qualifier(id)
	@Resource(id)   根据名称自动注入
	@PostConstruct  自定义初始化
	@PreDestroy     自定义销毁
	