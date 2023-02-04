import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        System.out.println(tiling(n));

    }

    public static int tiling(int width) {

        if (dp[width] > 0) {
            return dp[width];
        }

        for (int i = 3; i <= width; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }

        return dp[width];
    }
}
