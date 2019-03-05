缓冲流:
	也叫高效流, 基于基本流, 对基本流增强   装饰器模式

原理:
	在创建高效流对象时, 会创建一个内置的默认大小的缓冲区数组, 通过缓冲区读写, 减少IO次数, 提高效率

字节缓冲流:
	BufferedInputStream
	BufferedOutputStream
	
字符缓冲流:
	BufferedReader
	BufferedWriter
	
	