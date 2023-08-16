import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int K;
    static int[][] coins;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coins = new int[K][2];

        StringTokenizer st;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[T + 1][K + 1];
    }

    private static int solve() {
        for (int i = 0; i < K; i++) {
            dp[0][i] = 1;

            int value = coins[i][0];
            int cnt = coins[i][1];

            for (int j = 1; j <= cnt; j++) {
                int price = value * j;

                for (int k = price; k <= T; k++) {
                    dp[k][i + 1] += dp[k - price][i];
                }
            }

            for (int j = 1; j <= T; j++) {
                dp[j][i + 1] += dp[j][i];
            }
        }

        return dp[T][K];
    }

}