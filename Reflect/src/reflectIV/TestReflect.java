package reflectIV;

import java.lang.reflect.Constructor;

/**
* @author WaldenLu
* @data   2017年4月19日下午8:54:00
* 通过反射机制实例化一个类的对象
*/
public class TestReflect {
	public static void main(String[] args) throws Exception {
		Class<?> class1 = null;
		class1 = Class.forName("reflectIV.User");
		// 第一种方法，实例化默认构造方法，调用set赋值
		User user = (User) class1.newInstance();
		user.setAge(24);
		user.setName("Walden");
		System.out.println(user);
		// 第二种方法 取得全部的构造函数 使用构造函数赋值
		Constructor<?> cons[] = class1.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			Class<?> clazzs[] = cons[i].getParameterTypes();
			System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
			}
		user = (User) cons[1].newInstance("Rollen");
		System.out.println(user);
		user = (User) cons[0].newInstance(20,"Rollen");
		System.out.println(user);
		}
		
	}

