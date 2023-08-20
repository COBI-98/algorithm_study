import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            coins = new int[N+1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int amount = Integer.parseInt(br.readLine());

            dp = new int[amount+1];
            dp[0] = 1;

            sb.append(dynamicPrograming(N, amount) + "\n");
        }

        System.out.println(sb);
    }

    private static int dynamicPrograming(int n, int amount) {

        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
    
}