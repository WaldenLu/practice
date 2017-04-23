package reflectVIII;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WaldenLu
 * @data 2017年4月23日下午1:16:58
 * 反射机制的动态代理
 */

// 项目接口
interface Subject {
	public String say(String name, int age);
}

// 定义真实项目
class RealSubject implements Subject {
	public String say(String name, int age) {
		return name + " " + age;
	}
}


class MyInvocationHandler implements InvocationHandler {
	private Object obj = null;
	
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		/*Proxy.newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
                                      
                                      
                      参数：
			loader - 定义代理类的类加载器
			interfaces - 代理类要实现的接口列表
			h - 指派方法调用的调用处理程序 
			返回：
			一个带有代理类的指定调用处理程序的代理实例，它由指定的类加载器定义，并实现指定的接口
			
			
		 * 此方法相当于
		 
		 
		 * 
		Proxy.getProxyClass(loader, interfaces).
        getConstructor(new Class[] { InvocationHandler.class }).
        newInstance(new Object[] { handler });
        */

	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		Object temp = method.invoke(this.obj, args);
		return temp;
	}
}

/**
 * 在java中有三种类类加载器。
 * 
 * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
 * 
 * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jrelibext目录中的类
 * 
 * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
 * 
 * 如果想要完成动态代理，首先需要定义一个InvocationHandler接口的子类，已完成代理的具体操作。
 * 
 */

public class TestReflect {
    public static void main(String[] args) throws Exception {
    	
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
        System.out.println(info);
    }
}

