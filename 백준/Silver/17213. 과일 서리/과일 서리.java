import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    static int N;
    static int M;
    static int dp[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N + 1][M + 1];

        for(int j = 1; j <= M; j++) {
            dp[1][j] = 1;
        }
        
        solve();
        printResult();
    }
    
    private static void solve() { 
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
    }

    private static void printResult() { 
        System.out.println(dp[N][M]);
    }
}