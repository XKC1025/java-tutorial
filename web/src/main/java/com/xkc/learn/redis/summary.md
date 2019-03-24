redis:
	NoSQL内存数据库
	Key: Value结构
		
应用场景:
	1.缓存 	一块内存区域, 存放经常使用的资源
	2.聊天室在线好友列表
	3.任务队列 秒杀/抢购/12306
	4.应用排行榜
	5.网站访问统计
	6.数据过期处理 (可以精确到秒)
	7.分布式集群架构中的session分离
	
redis数据结构:
	key都是String类型
	value五种数据结构:
		1.String
		2.Hash       类似Map
		3.List       类似LinkedList
		4.Set
		5.SortedSet  自动排序
		
String类型:
		set key value
		get key
		del key
		
Hash类型:
		hset map field value
		hget map field 
		hdel map field
		hgetall 获取所有的K-V
		
List类型:
		lpush list value       左边添加
		rpush list value       右边添加
		lrange list start end  切片
		lpop list              左边删除元素
		
Set类型:
		sadd set value1, value2... 添加元素
		smembers set  获取set中全部元素
		srem set value  删除指定元素
		
SortedSet类型:
		zadd key score value  根据score进行排序
		zrange key start end  切片
		zrem key value        删除指定成员
		
通用命令:
		keys *   正则匹配所有的key
		type key 查看key的数据类型
		del key  删除指定的key
		
Redis持久化:
		1.RDB
			默认方式, 间隔检测key的变化情况, 然后持久化数据, 对性能影响低
			配置文件有备份规则
		2.AOF
			日志记录的方式, 可以记录每一条命令的操作, 可以每一次命令操作后, 持久化数据
			配置文件 appendonly yes       (开启aof)
					appendfsync always   每一次操作都会持久化
					appendfsync everysec 每隔1秒进行持久化