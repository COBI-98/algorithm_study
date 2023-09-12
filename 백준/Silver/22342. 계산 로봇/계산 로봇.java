import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] weight;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        weight = new int[N + 2][M];
        dp = new int[N + 2][M];
        
        for(int i=1; i<=N;i++){
            String str = br.readLine();
            for(int j=0; j<M;j++){
                weight[i][j] = str.charAt(j) - '0';
            }
        }
        
    }
    
    private static void solve(){
        int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(j>0) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1])) + weight[i][j];
					answer = Math.max(answer, dp[i][j]);
				}else {
					dp[i][j] = weight[i][j];
				}
			}
		}
        
        System.out.println(answer);
    }
}