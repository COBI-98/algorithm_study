import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int k;
    static int n;
    static long answer = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][k + n + 1];

        dp[0][k] = 1L;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + n; j++) {
                dp[i + 1][j - 1] += dp[i][j];
                dp[i + 1][j + 1] += dp[i][j];
            }
        }

        for (int i = 1; i < dp[0].length; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer);
    }
}