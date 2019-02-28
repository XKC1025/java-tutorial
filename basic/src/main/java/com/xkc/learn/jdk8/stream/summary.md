Stream流:
	将集合或数组转成Stream流, 在流对象上进行一系列操作
	调用终结方法时, count(), collect(), foreach()等, 流式操作才会执行
	
Pipelining:
	map(), sort(), filter()等中间操作都会返回新的流对象, 多个管道可以串联
	
内部迭代:
	流对象在内部隐式的进行迭代操作