import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int K;
    public static int W;
    public static int V;
    public static int[][] arr;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][2];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            arr[i][0] = W;
            arr[i][1] = V;
        }

        System.out.println(bag(K));
    }

    public static int bag(int weight) {

        for (int k = 1; k <= K; k++) { // 무게
            for (int i = 1; i <= N; i++) { // arr
                dp[i][k] = dp[i - 1][k];
                if (k - arr[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], arr[i][1] + dp[i - 1][k - arr[i][0]]);
                }
            }
        }
        return dp[N][weight];
    }
}
