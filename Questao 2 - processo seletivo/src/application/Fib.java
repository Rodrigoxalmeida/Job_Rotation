package application;

public class Fib {

	public static void main(String[] args) {
		
		//SEQUENCE NUMBER
		int n = 89;
		int stringSize = 30;		
		
		boolean result = false;
		
		for (int i = 0; i < stringSize; i++) {
			//System.out.println("( "+ i + " ) " + Fib.fibo(i));
			
			if(Fib.fibo(i) == n) {
				result = true;
			}
			
		}
		
		if(result) {
			System.out.println("o numero " + n + " pertence a sequência fibonacci");
		}else {
			System.out.println("o numero " + n + " não pertence a sequência fibonacci");
		}
		
		

	}
	
	public static long fibo(int n) {
		if(n < 2) {
			return n;
		}else {
			return fibo(n -1) + fibo(n - 2);
		}
	}

}
