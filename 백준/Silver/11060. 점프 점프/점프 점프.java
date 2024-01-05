import java.util.*;
import java.io.*;
public class Main {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] dp = new long[1101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = INF;
        }
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] >= INF) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        if (dp[n] >= INF) {
            System.out.print(-1);
        } else {
            System.out.print(dp[n]);
        }
    }
}