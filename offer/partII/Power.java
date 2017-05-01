package offer.partII;

/**
* @author WaldenLu
* @data   2017年4月19日下午4:56:59
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/
public class Power {
	public static double power(double base, int exponent){
		double solution = 0 ;
		if (exponent==0) {
			if (base == 0) {
				System.err.println("err");
			}else {
				solution = 1;
			}
		}else {
			if (exponent > 0) {
				solution = pow(base, exponent);
			}else{
				solution = 1/pow(base, -exponent);
			}
		}
		return solution;
		
	}
	
	//exponent>0
	public static double pow(double base, int exponent){
		double solu = 1;
		while(exponent>0){
			solu *= base;
			exponent -= 1;
		}
		return solu;
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 5));
		System.out.println(pow(2, 1));
	}
}
