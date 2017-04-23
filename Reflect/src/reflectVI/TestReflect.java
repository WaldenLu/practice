package reflectVI;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
* @author WaldenLu
* @data   2017年4月23日上午11:20:10
* 获取某个类的全部方法
*/
public class TestReflect implements Serializable{

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) throws Exception{
		Class<?> clazz = Class.forName("reflectVI.TestReflect");
		Method method[] = clazz.getMethods();
		for (int i = 0; i < method.length; i++) {
			Class<?> returnType = method[i].getReturnType();
			Class<?> para[] = method[i].getParameterTypes();
			//获取修饰符 直接得到是一个整数 相当于一个编码 查表得到具体的修饰符
			int temp = method[i].getModifiers();
			System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
            
		}
	}
	
	
}
