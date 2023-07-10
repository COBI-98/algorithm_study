import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            dp[i] = time;

            for (int j = 0; j < num; j++) {
                int temp = Integer.parseInt(st.nextToken());

                dp[i] = Math.max(dp[i], dp[temp] + time);
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
