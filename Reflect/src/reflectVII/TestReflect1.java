package reflectVII;

import java.lang.reflect.Field;

/**
* @author WaldenLu
* @data   2017年4月23日下午12:15:20
* 
*/
public class TestReflect1 {
	private static String proprety = "null";
	public static void main(String[] args) throws Exception{
		Class<?> clazz = Class.forName("reflectVII.TestReflect1");
		System.out.println(proprety);
		Object object = clazz.newInstance();
		Field field = clazz.getDeclaredField("proprety");
		field.setAccessible(true);//设置访问权限  private默认是没有访问权限的
		field.set(object,"Java反射机制");
		System.out.println();
		System.out.println(field.get(object));
		
	}
}
