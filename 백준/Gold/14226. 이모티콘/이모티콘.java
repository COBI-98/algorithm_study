import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        dp[1][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int clip = current[1];

            if (now == n) {
                System.out.println(dp[now][clip]);
                break;
            }

            if (dp[now][now] == -1) {
                dp[now][now] = dp[now][clip] + 1;
                queue.add(new int[]{now, now});
            }

            if (now + clip <= n && dp[now + clip][clip] == -1) {
                dp[now + clip][clip] = dp[now][clip] + 1;
                queue.add(new int[]{now + clip, clip});
            }

            if (now - 1 >= 0 && dp[now - 1][clip] == -1) {
                dp[now - 1][clip] = dp[now][clip] + 1;
                queue.add(new int[]{now - 1, clip});
            }
        }
    }
}