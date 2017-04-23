package reflectIII;

import java.io.Serializable;

/**
* @author WaldenLu
* @data   2017年4月19日下午8:47:15
* 获取一个对象的父类与实现的接口
*/
public class TestReflect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) throws Exception{
		Class<?> clazz = Class.forName("reflectIII.TestReflect");
		Class<?> parentClazz = clazz.getSuperclass();
		System.out.println("clazz的父类为" + parentClazz.getName());
		Class<?> intes[] = clazz.getInterfaces();
		System.out.println("clazz实现的接口有：");
		for (int i = 0; i < intes.length; i++) {
			System.out.println(i+1+" : " + intes[i].getName());
		}
	}
}
