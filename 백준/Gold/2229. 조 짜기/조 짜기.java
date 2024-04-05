import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] arr;
    static int[] dp;
    
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 1] + groupScore(j, i, arr));
            }
        }
    }

    public static int groupScore(int startIdx, int endIdx, int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = startIdx - 1; i <= endIdx - 1; i++) {
            maxVal = Math.max(arr[i], maxVal);
            minVal = Math.min(arr[i], minVal);
        }
        return maxVal - minVal;
    }

    private static void printResult() {
        System.out.println(dp[N]);
    }

}
