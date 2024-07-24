import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        prev = new int[n + 1];
    }

    private static void solve() {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");

        List<Integer> path = new ArrayList<>();
        for (int i = n; i >= 1; i = prev[i]) {
            path.add(i);
        }
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}