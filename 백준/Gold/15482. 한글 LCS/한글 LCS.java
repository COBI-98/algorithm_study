import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static String s1;
    static String s2;
    static int[][] dp;
    static int n;
    static int m;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        
        n = s1.length();
        m = s2.length();
        
        dp = new int[n + 1][m + 1];
    }
    
    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
    }
    
    private static void printResult() {
        System.out.print(dp[n][m]);
        
    }
}