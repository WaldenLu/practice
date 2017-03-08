package cn.waldenlu.def;

/**
* @author ssscorch
* @data   
*
*/
import java.util.regex.*;


public class Pretreatment {
	
	private  int len;
	static int mark;
	private  char[] output;
	private  int deciLen;
	private  int intLen;
		
	public boolean isNum(String input){
		output = input.toCharArray();
		len = output.length;
		int length = len;
		
		//找小数点的位置mark 存在返回index,不存在返回-1
		
		for (int i = 0; i < len; i++) {
			if(output[i]=='.'){
				mark = i;
				break;
			}else{
				mark = -1;
			}
		}
		
		if(mark!=-1){			
			deciLen = length - mark - 1;
			intLen = length - deciLen -1;					
		}else{
			deciLen = 0;
			intLen = length;
		}
		
		Pattern pattern = Pattern.compile("[0-9]+.[0-9]+");
		Matcher m = pattern.matcher(input);
		int flag = input.length();
		boolean flag1 = deciLen<3;
		
		return (m.matches()&&(flag<13)&&flag1);

	}

	public  int getLen() {
		return len;
	}

	public static int getMark() {
		return mark;
	}

	public  char[] getOutput() {
		return output;
	}

	public  int getDeciLen() {
		return deciLen;
	}

	public  int getIntLen() {
		return intLen;
	}
	
	
	/*public static void main(String[] args) {
		String input = "1625.1";
		Pretreatment pretreatment = new Pretreatment();
		boolean flag = pretreatment.isNum(input);
		if(flag){
		System.out.println(len);
		System.out.println(mark);
		System.out.println(deciLen);
		System.out.println(output);
		System.out.println(intLen);
		}else{
			System.out.println("false");
		}
	}*/
	
	
	
}
