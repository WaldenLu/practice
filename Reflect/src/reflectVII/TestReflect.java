package reflectVII;

import java.lang.reflect.Method;

/**
* @author WaldenLu
* @data   2017年4月23日下午12:06:05
* 通过反射机制调用某个类的方法
*/
public class TestReflect {
	
	
	public void reflect1(){
		System.out.println("Java反射机制 - 调用某个类的方法1");
	}
	
	public void reflect2(int age, String name){
		System.out.println("Java反射机制 - 调用某个类的方法2");
		System.out.println("age->" + age + ". name->" + name);
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("reflectVII.TestReflect");
		// 调用TestReflect类中的reflect1方法
		Method method1 = clazz.getMethod("reflect1");
		method1.invoke(clazz.newInstance());
		//"Java反射机制 - 调用某个类的方法1"
		
		// 调用TestReflect的reflect2方法
		Method method2 = clazz.getMethod("reflect2", int.class, String.class);
		method2.invoke(clazz.newInstance(), 20, "张三");
		// Java 反射机制 - 调用某个类的方法2.
        // age -> 20. name -> 张三
	}
}
