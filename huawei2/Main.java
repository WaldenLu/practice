package huawei2;

import java.util.Scanner;

/**
* @author ssscorch
* @data   
* 华为2017校园招聘笔试题2
* 骰子 初始值 前1后2左3右4上5下6
* 输入一串指令 RA 得到当前前后左右上下的数值
*/
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String operation = in.nextLine();
		in.close();
		int[] input = {1,2,3,4,5,6};
		Main main = new Main();
		if(operation.length()>50)
		{
			System.err.println("错误");
		}
		for (int i = 0; i < operation.length(); i++) {
			char key = operation.charAt(i);
			switch (key) {
			case 'A':main.A(input);
			break;
			case 'B':main.B(input);
			break;
			case 'C':main.C(input);
			break;
			case 'F':main.F(input);
			break;
			case 'R':main.R(input);
			break;
			case 'L':main.L(input);
			break;
			}
		}
	
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
	}
	
	//向左翻转
	public void L(int[] input)
	{
		swap(input, 1, 5);
		swap(input, 4, 5);
		swap(input, 0, 5);
		
	}
	
	//向右翻转
	public void R(int[] input)
	{
		swap(input, 0, 5);
		swap(input, 4, 5);
		swap(input, 1, 5);
		
	}
	//向前翻转
	public void F(int[] input)
	{
		swap(input, 4, 5);
		swap(input, 3, 4);
		swap(input, 2, 5);
		swap(input, 1, 4);
		swap(input, 0, 5);
	}
	//向后翻转
	public void B(int[] input)
	{
		swap(input, 0, 5);
		swap(input, 1, 4);
		swap(input, 2, 5);
		swap(input, 3, 4);
		swap(input, 4, 5);
		
	}
	//逆时针旋转90°
	public void A(int[] input){
		swap(input, 0, 3);
		swap(input, 1, 2);
		swap(input, 2, 3);
	}
	//顺时针旋转90°
	public void C(int[] input){
		swap(input, 2, 3);
		swap(input, 1, 2);
		swap(input, 0, 3);
	}
	
	//对换位置函数
	public void swap(int[] input,int a, int b)
	{
		int temp = 0;
		temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
