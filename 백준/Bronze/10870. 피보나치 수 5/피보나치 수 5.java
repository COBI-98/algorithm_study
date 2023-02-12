import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int x;	

		Scanner sc= new Scanner(System.in);
		x = sc.nextInt();


		System.out.println(fibo(x));

	}

	
	public static int fibo(int n) {
		
		if (n <= 1)
			return n;
		else 
			return fibo(n-2) + fibo(n-1);
	}
	
}