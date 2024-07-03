# DI入门案例分析思路
1、基于IOC管理bean。
2、Service中使用new形式创建的Dao对象不保留。
3、Service中需要的Dao对象将通过提供方法进入到Service中。
4、Service与Dao间的关系如何描述？

## NoSuchBeanDefinitionException: No bean named 'bookService22' available
这个一般是配置文件和测试里面的bean名字不一致。

## bean作用范围说明
1、bean默认是单例的
2、适合交给容器的管理的bean
   ·表现层对象
   ·业务层对象
   ·数据层对象
   ·工具层对象
3、不适合交给容器管理的bean
   ·封装实体的域对象
