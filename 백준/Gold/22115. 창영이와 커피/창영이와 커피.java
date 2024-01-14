import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    private static final int INF = 987654321;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k,c,i;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		st = new StringTokenizer(br.readLine());
		Arrays.fill(dp, INF);
		dp[0] = 0;
		while(n-->0) {
			c = Integer.parseInt(st.nextToken());
			for(i=k;i>=c;i--) dp[i] = Math.min(dp[i], dp[i-c]+1);
		}
		System.out.println(dp[k]>100?"-1":dp[k]);
	}
}