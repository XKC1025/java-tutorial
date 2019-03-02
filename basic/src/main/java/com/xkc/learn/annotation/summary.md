注解:
	在代码上添加额外的信息 / 功能
	
作用:
	编写文档: 通过代码里标识的注解生成文档 Swagger文档/ javadoc class.java抽取成官方文档
	代码分析: 通过代码标识的注解对代码进行分析\[利用反射\]
	编译检查: 例如@Override
	
内置注解:
	@Override
	@Deprecated
	@SuppressWarnings
	
元注解:
	用于描述注解的注解
	@Target:
		描述注解能够作用的位置
	@Retention:
		描述注解被保留的阶段
	@Documented:
		描述注解是否被抽取到API文档中
	@Inherited:
		描述注解是否被子类继承

注解的本质:
	本质上是一个接口, 默认继承Annotation接口
	接口中能定义的成员, 注解中都可以定义
	接口中的抽象方法, 注解中称为属性
	public interface MyAnno extends java.lang.annotation.Annotation{}
	
注解属性要求:
	基本数据类型
	String
	枚举
	注解
	以上类型的数组

注意:	
	使用default给属性初始化值
	如果只有一个属性, 属性名是value, 注解赋值时value=可省略
	