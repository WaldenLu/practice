package reflectV;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
* @author WaldenLu
* @data   2017年4月19日下午10:16:06
* 获取某个类的全部属性
*/
public class TestReflect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception{
		Class<?> clazz = Class.forName("reflectV.TestReflect");
		System.out.println("===============本类属性===============");
		//获取本类的全部属性
		Field[] fields = clazz.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			//修饰权限
			int mod = fields[i].getModifiers();
			String priv = Modifier.toString(mod);
			//属性类型
			Class<?> type = fields[i].getType();
			System.out.println(priv + " " + type.getName() + " " + fields[i].getName() + ";");
		}
		
		System.out.println("==========实现的接口或者父类的属性==========");
		//取得实现的接口或者父类的属性
		 Field[] filed1 = clazz.getFields();
	        for (int j = 0; j < filed1.length; j++) {
	            // 权限修饰符
	            int mo = filed1[j].getModifiers();
	            String priv = Modifier.toString(mo);
	            // 属性类型
	            Class<?> type = filed1[j].getType();
	            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
	        }
	
	}
}
