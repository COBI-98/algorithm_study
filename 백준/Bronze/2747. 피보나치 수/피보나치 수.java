import java.io.*;

public class Main {
	public static int n;
	public static long [] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long [n+1];
		dp[0] = 0L;
		dp[1] = 1L;
	
		System.out.println(fibonachi(n));
	}
	
	public static long fibonachi(int count) {
		
		if(count<2) {
			return dp[count];
		}
		
		for(int i=2; i<=count; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[count];
	}
}
