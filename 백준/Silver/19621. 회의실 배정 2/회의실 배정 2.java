import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][3];

        for (int i = 0; i < N; i++) {
            meetings[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[N];
        dp[0] = meetings[0][2];

        for (int i = 1; i < N; i++) {
            int maxPrevDp = 0;
            for (int j = 0; j < i; j++) {
                if (meetings[i][0] >= meetings[j][1]) {
                    maxPrevDp = Math.max(maxPrevDp, dp[j]);
                }
            }
            dp[i] = Math.max(dp[i - 1], meetings[i][2] + maxPrevDp);
        }

        System.out.println(dp[N - 1]);
    }
}