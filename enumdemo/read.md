# 单例
    这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
    注意：
        1、单例类只能有一个实例。
        2、单例类必须自己创建自己的唯一实例。
        3、单例类必须给所有其他对象提供这一实例。
# 优势
    1.书写简单，仅仅5行代码就能实现单例模式。
    
    2.枚举类能防止破坏单例模式。
    
    2.1.枚举类能防止利用反射方式获取枚举对象
    
    原因：调用反射newInstance方法时会检查是否为枚举类，如果是将报错，错误如下：
    
    Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
    
    2.2.枚举类能防止使用序列化与反序列化获取新的枚举对象
    
    原因：在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。同时，编译器是不允许任何对这种序列化机制的定制的，因此禁用了writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法。
  

