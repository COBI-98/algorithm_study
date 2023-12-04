import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    
    static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int dp[] = new int[c + 101]; 
		Arrays.fill(dp, INF);
        
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for(int j=customer; j<c + 101; j++) {
				if (dp[j-customer] != INF)
					dp[j] = Math.min(dp[j], cost+dp[j-customer]);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=c; i<c+100; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);
		
	}

}