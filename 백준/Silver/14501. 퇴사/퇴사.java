import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][2];
        dp = new int[N + 1];
        for (int i = N; i > 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i][0] = A;
            arr[i][1] = B;
        }

        System.out.println(consulting(N));
    }

    public static int consulting(int day) {

        for (int i = 1; i <= N; i++) {
            if (arr[i][0] > i) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], arr[i][1] + dp[i - arr[i][0]]);
            }
        }
        return dp[day];
    }
}
