package offer;
/**
* @author WaldenLu
* @data   2017年4月19日下午2:36:00
*
*/
public class JumpFloorII {
	public static int jumpFloorII(int target) {
        if(target <= 0)
            return 0;
        else if(target == 1)
        	return 1;
        else{
            int solu = 1;
            int count = target - 1;
         while(count >= 1){
             solu*=2;
             count--;
         }  
            return solu;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(JumpFloorII.jumpFloorII(4));
	}
}
