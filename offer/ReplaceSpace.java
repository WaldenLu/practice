package offer;

/**
* @author ssscorch
* @data   
* 剑指offer 替换空格为%20
* 用一个数组标记空格位置，从后向前替换
*/
public class ReplaceSpace {
	

	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer(" he llo wor ld!");
		int len = sBuffer.length();
		int[] index = new int[100];
		int count = 0;
		//标记空格位置 记录下有效长度count
		for(int i=0,j=0;i<len;++i){
			if(sBuffer.charAt(i)==' ')
				index[j++] = i;
				count = j;
		}

		
		for(int i=count-1;i>=0;--i){
			sBuffer.replace(index[i], index[i]+1, "%20");
		}
		
		String string =	sBuffer.toString();
		System.out.println(string);
	}
}
