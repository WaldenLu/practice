package reflectIX;
/**
* @author WaldenLu
* @data   2017年4月23日下午3:32:31
*
*/
interface fruit {
    public abstract void eat();
}

public class Apple implements fruit {
    public void eat() {
        System.out.println("Apple");
    }
}
class Orange implements fruit {
    public void eat() {
        System.out.println("Orange");
    }
}
class Factory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}