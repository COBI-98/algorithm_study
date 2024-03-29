import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int DIV = 1_000_000;
    static int n;
    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3][4];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0, 0, 0));
    }

    static int solve(int len, int late, int absent) {
        if (dp[len][late][absent] != -1) {
            return dp[len][late][absent];
        }
        if (late > 1 || absent == 3) {
            return 0;
        }
        if (len > n - 1) {
            return 1;
        }

        dp[len][late][absent] = 0;

        dp[len][late][absent] = solve(len + 1, late, 0)
                + solve(len + 1, late, absent + 1)
                + solve(len + 1, late + 1, 0);

        return dp[len][late][absent] % DIV;

    }
}