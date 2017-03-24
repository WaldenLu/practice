package huawei;
//华为机试第一题
//反转相加
//输入123，100
//输出322
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	      	String input = in.nextLine();
	      	String inputnum[] = input.split(",");
	      	String stringa = inputnum[0];
	      	String stringb = inputnum[1];
	            int a = Integer.valueOf(stringa).intValue();
	            int b = Integer.valueOf(stringb).intValue();
	        	Main test1 = new Main();
	    		int sum = test1.reverseAdd(a, b);
            	System.out.println(sum);
	        in.close();
	}
    
	
	public int reverseAdd(int a, int b){
		
		if(a<1||a>70000||b<1||b>70000){
			return -1;
		}
		
		String stringa = String.valueOf(a);
		String stringb = String.valueOf(b);
		//charAt(i)
		//翻转字符串
		String re_a = ""; 
		String re_b = ""; 
		
		for (int i = stringa.length()-1; i >= 0; i--) {
			re_a = re_a+stringa.charAt(i);
		}
		for (int i = stringb.length()-1; i >= 0; i--) {
			re_b = re_b+stringb.charAt(i);
		}
	
		//截断0 substring(begin)
		int index_a = 0;
		for (int i = 0; i < re_a.length(); i++) {
			if(re_a.charAt(i)!=0){
				index_a = i;
				break;
			}	
		}
		String aString = re_a.substring(index_a);
		
		int index_b = 0;
		for (int i = 0; i < re_b.length(); i++) {
			if(re_b.charAt(i)!=0){
				index_b = i;
				break;
			}	
		}
		String bString = re_b.substring(index_b);
	
		int numa = Integer.valueOf(aString).intValue();
		int numb = Integer.valueOf(bString).intValue();
		return (numb+numa);
	}
		
}
