import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        dp = new long[65][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for (int test_case = 0; test_case < T; test_case++) {
            n = Integer.parseInt(br.readLine());
            long ans = 0;

            for (int j = 0; j <= 9; j++) {
                ans += dp[n][j];
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
