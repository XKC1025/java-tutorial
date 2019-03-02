Throwable异常体系:
	Error:
		严重的错误, JVM都无法处理
	Exception: 
		异常产生后, 程序可以进过处理继续执行
		
异常的分类:
	Exception:        编译期异常, 写代码时出现的问题
    RuntimeException: 运行期异常
    Error:            无法恢复, 必须修改代码

throw:
	在指定的方法中抛出指定的异常  throw new MyException(\"异常产生的原因\");
	new的对象必须是Exception和Exception的子类对象
	1.抛出的是编译异常(Exception及其继承的自定义子类), 必须处理, 要么throws, 要么try...catch...
	2.抛出的是RuntimeException及其子类(NullPointerException或者自定义子类), 可以不处理, 默认交给JVM处理

throws:
	异常处理的第一种方式
	抛出的异常有子父类异常, 直接声明父类异常
	把异常抛给调用者去处理   public void method() throws Exception {}
	
try...catch...finally
	捕获异常, 异常处理的第二种方式
	不会抛出异常, 在本方法内对异常进行处理
	try {可能出现异常的代码} catch (Exception) {对异常处理的逻辑, 记录日志}
		