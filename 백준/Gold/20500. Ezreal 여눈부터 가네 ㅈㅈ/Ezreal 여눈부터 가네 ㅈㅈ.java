import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long MOD = 1000000007L;
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("0");
            return;
        }

        long[][] dp = new long[3][N + 1];
        dp[0][2] = dp[1][2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % MOD;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
        }

        System.out.println(dp[0][N]);
    }

}