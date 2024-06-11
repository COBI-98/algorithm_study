import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_009;
    static int T;
    static int dp[][];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        dp = new int[1001][1001];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;

        for (int r = 4; r <= 1000; r++) {
            dp[r][r] = 1;

            for (int c = 2; c < r; c++) {
                dp[r][c] = (dp[r - 1][c - 1] + dp[r - 2][c - 1]) % MOD;
                dp[r][c] = (dp[r][c] + dp[r - 3][c - 1]) % MOD;
            }
        }

        for (int run = 0; run < T; run++) {
            st = new StringTokenizer(br.readLine());
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}