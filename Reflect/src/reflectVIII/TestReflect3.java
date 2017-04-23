package reflectVIII;

import java.lang.reflect.Array;

/**
* @author WaldenLu
* @data   2017年4月23日下午3:13:44
* 通过反射取得并修改数组的信息
*/
public class TestReflect3 {
	public static void main(String[] args) throws Exception{
		int[] temp = {1,2,3,4,5};
		Class<?> demo = temp.getClass().getComponentType();
		System.out.println("数组类型:" + demo.getName());
		System.out.println("数组长度:" + Array.getLength(temp));
		System.out.println("数组第一个元素:" + Array.get(temp, 0));
		Array.set(temp, 0, 100);
		System.out.println("修改后第一个元素:" + Array.get(temp, 0));
	}
}
