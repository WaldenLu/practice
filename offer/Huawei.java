package offer;

/**
* @author ssscorch
* @data   
* 提供函数swapWithZero 用来和零交换
* 
* 只使用这个和零交换的函数 实现排序数组array
*/
public class Huawei {
	
	public void swapWithZero(int[] arrary, int len, int n){
		int zeroindex = 0;
		int nindex = 0;
		for(int i=0;i<len;++i){
			if(arrary[i]==0){
				zeroindex = i;
			}
		}
		for(int i=0;i<len;++i){
			if(arrary[i]==n){
				nindex = i;
			}
		}
		int temp = 0;
		temp = arrary[zeroindex];
		arrary[zeroindex] = arrary[nindex];
		arrary[nindex] = temp;
	}
	
	//每次返回这个array中的最小的数字
	public void  sort(int[] array, int len){
		//完成函数
		/**
		 * i指针指向目标位置
		 * 先找到0的位置，把0和a[i]交换
		 * 找到当前数组中从i向后的最小值，再(和a[0]比较),得到最后的最小值
		 * 把最小值放和0互换
		 * 指针加一
		 * */
		int length = array.length;
		for (int i = 1; i < length; i++) {
			
	/*		//找到0的位置
			for(int j=0;j<length;++j){
				if(array[j]==0){
					zeroindex = j;
					break;
				}
			}*/
			
			swapWithZero(array,length,array[i]);//0和指针位置的值交换
			
			//找到当前数组中最小的数字min
			int min = length;
			for(int j=i+1;j<length;++j){
				if(array[j]<min){
					min=array[j];
				}
				if (min<array[0]) {
					
				} else {
					min = array[0];
				}
			}
			swapWithZero(array,length,min);//0和最小值交换
		}
		
	}
	
	public static void main(String[] args) {
		Huawei solution = new Huawei();
		int[] test = {2,1,7,0,3,4,6,5,8};
		solution.sort(test, 9);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]);
		}
		
	}
	
}
