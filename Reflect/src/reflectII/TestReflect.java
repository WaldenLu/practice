package reflectII;
/**
* @author WaldenLu
* @data   2017年4月19日下午8:42:44
* 实例化Class类对象
*/
public class TestReflect {
	public static void main(String[] args) throws Exception {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		
		class1 = Class.forName("reflectII.TestReflect");
		class2 = new TestReflect().getClass();
		class3 = TestReflect.class;
		System.out.println("类名称" + class1.getName() );
		System.out.println("类名称" + class2.getName() );
		System.out.println("类名称" + class3.getName() );
	}
}
