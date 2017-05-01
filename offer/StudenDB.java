package offer;
/**
* @author ssscorch
* @data   
*	
* 输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
*/

import java.util.Scanner;


/**
 * 输入：
 *  5 7
	1 2 3 4 5
	Q 1 5
	U 3 6
	Q 3 4
	Q 4 5
	U 4 5
	U 2 9
	Q 1 5
 * */

/*
 * 输出：
 * 5
 * 6
 * 5
 * 9
 * */

public class StudenDB {
	
	public static void main(String[] args) {
		int student = 0;
		int operation = 0;
		Scanner inScanner = new Scanner(System.in);
		
			student = inScanner.nextInt();
			operation = inScanner.nextInt();
			int[] score = new int[student];
			
			for (int i = 0; i < student; i++) {
				score[i] = inScanner.nextInt();
			}
			
			int start = 0;
			int end = 0;
			String request = null;
			for (int i = 0; i < operation; i++) {
				
			
			request = inScanner.next();
			start = inScanner.nextInt();
			end = inScanner.nextInt();
			start = Math.min(start, end);
			end = Math.max(start, end);
			if(request.equals("Q")){
				 int solution = (new StudenDB()).operationQ(score, start, end);
				 System.out.println(solution);
			
			}else {
				(new StudenDB()).operationU(score, start, end);
			
			}
		
		}
		
		inScanner.close();
	}
	
	//询问操作
	public int operationQ(int[] score,int start, int end) {
		int max = -1;
		for(int i=start-1;i<end;i++){
			if(score[i]>max)
				max = score[i];
		}
		return max;
	}
	//更新操作
	public void operationU(int[] score,int start, int end){
		score[start-1] = end;
	}
		
}
