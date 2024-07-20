import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int [] dp;
    static String blocks;
    static int N;

    public static void main(String args[]) throws IOException {
        init();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        blocks = br.readLine();

        dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (solve(blocks.charAt(i), blocks.charAt(j)) && dp[i] != INF) {
                    int energe = (j - i) * (j - i);
                    dp[j] = Math.min(dp[j], dp[i] + energe);
                }
            }
        }
    }

    private static boolean solve(char from, char to) {
        if (from == 'B' && to == 'O') {
            return true;
        }
        if (from == 'O' && to == 'J') {
            return true;
        }
        if (from == 'J' && to == 'B') {
            return true;
        }

        return false;
    }

    private static void printResult() {
        if (dp[N - 1] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}