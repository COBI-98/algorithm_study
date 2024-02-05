import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_000;
    static int N;
    static long [] dp;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1] = 0;
        dp[2] = 1;
    }

    private static long solve() {
        for (int i = 3; i <= N; i++) {
            dp[i] = (((i-1) * dp[i-1]) + ((i-1) * dp[i-2])) % MOD;
        }

        return dp[N];
    }

}