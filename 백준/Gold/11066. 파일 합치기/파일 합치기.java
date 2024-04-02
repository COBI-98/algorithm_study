import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[] sum = new int[501];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
            }
            
            fileMerge(K);
            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);
    }

    public static void fileMerge(int K) {
        for (int i = 2; i <= K; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int s = j; s < i; s++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
                }
                dp[j][i] += sum[i] - sum[j - 1];
            }
        }
    }
}