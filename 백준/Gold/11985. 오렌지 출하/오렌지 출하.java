import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static long K;
    static long oranges[];
    static long dp[];

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        oranges = new long[N + 1];
        dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            oranges[i] = Long.parseLong(br.readLine());
        }
    }

    private static void solve() {
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            long max = 0;
            long min = Long.MAX_VALUE;
            for (int j = 1; j <= M; j++) {
                if (i < j) {
                    break;
                }

                max = Math.max(max, oranges[i - j + 1]);
                min = Math.min(min, oranges[i - j + 1]);
                dp[i] = Math.min(dp[i], dp[i - j] + K + j * (max - min));
            }
        }
    }

    private static void printResult() {
        System.out.println(dp[N]);
    }
}

