import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= N; k++) {
                A[k] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - A[i] > 0) {
                        dp[j] += dp[j - A[i]];
                    } else if (j - A[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[M]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}