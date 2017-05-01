package offer;

/**
 * @author ssscorch
 * @data 斐波那契数列
 */
public class Fibonacci {

	public int FibonacciNum(int n) {
		if (n == 0) {
			return 0;
		} else {
			int fibo[] = new int[n + 1];
			fibo[0] = 1;
			fibo[1] = 1;
			for (int i = 2; i <= n; i++) {
				fibo[i] = fibo[i - 1] + fibo[i - 2];
			}
			return fibo[n - 1];
		}
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int solution = fibonacci.FibonacciNum(4);
		System.out.println(solution);
	}
}
