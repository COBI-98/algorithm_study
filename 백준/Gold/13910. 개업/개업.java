import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] woks;
    static int[] dp;
    static final int INF = 10001;
    
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        woks = new int[M];
        dp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        Arrays.fill(dp, INF);
        
        for(int i=0; i<M;i++){
            woks[i] = Integer.parseInt(st.nextToken());
            // 큰 웍 필요 x
            if (woks[i] <= N) {
                dp[woks[i]] = 1;
            }
        }
        
    }
    
    private static void solve(){
        
        twoWoksMaking();
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i - j < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        
        System.out.println(dp[N] == INF ? -1 : dp[N]);
    }
    
    private static void twoWoksMaking(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (woks[i] + woks[j] <= N && i != j) {
                    dp[woks[i] + woks[j]] = 1;
                }
            }
        }
    }

}