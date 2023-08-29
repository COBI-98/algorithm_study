import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] a;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        a = new int[N + 1];
        dp = new int[N + 1];

        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());

            if (a[i] > dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = a[i];
            }
            
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
