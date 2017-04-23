package reflectVIII;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
* @author WaldenLu
* @data   2017年4月23日下午3:00:18
* 在泛型为Integer的ArrayList中存放一个String类型的对象
*/
public class TestReflect2 {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		Method method = list.getClass().getMethod("add", Object.class);
		method.invoke(list, "Java反射机制实例.");
		
		System.out.println(list.get(0) + " " + list.get(1));
	}
}
