package models;

public class FibonacciNumbers {

	public void Get_Fib_Iterative(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		while (n >= 0) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;
			n--;
		}
	}

	public int Get_Fib_Recursive(int n) {
		if (n == 0) {
			return n;
		} else if (n == 1) {
			return n;
		} else {
			return Get_Fib_Recursive(n - 1) + Get_Fib_Recursive(n - 2);
		}
	}

	public void Print_N_Fibonacci(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(Get_Fib_Recursive(i) + " ");
		}
	}
}
