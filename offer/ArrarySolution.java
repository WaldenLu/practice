package offer;

/**
* @author ssscorch
* @data   
* 牛课网剑指offer算法题
* 代码丑陋
*/
public class ArrarySolution {
	public boolean Find(int target, int[][] array){
        if(array==null||array.length==0||(array.length==1&&array[0].length==0))
        	return false;//数组判空
		int rows = array.length;
        int cols = array[0].length;
		boolean flag = false;

		if(array[rows-1][cols-1]<target||array[0][0]>target)
			return false;//在数组值范围之外
		if (array[0][cols-1]==target) {
			return true;
		}

		int i = rows - 1;
		int j = 0;
		try{
		while(true){
		if(array[i][j]<target){
				j++;
			}else if (array[i][j]>target) {
				i--;
			}else {
				flag = true;
				break;
			}
		}
		}catch (Exception e) {
			flag = false;
		}
		return flag;
	}
 	
	//测试类
	public static void main(String[] args) {
		
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

//		int target = 7;
		int target = 5;
		ArrarySolution solution = new ArrarySolution();
		int n = array.length;
		System.out.println(n);
		boolean Flags = solution.Find(target,array);
		System.out.println(Flags);
		}
		
		
}

