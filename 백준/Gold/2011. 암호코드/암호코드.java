import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String code;
    static int len;
    static int[] arr;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
        printResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine();
        len = code.length();
        arr = new int[len+1];
        dp = new int[len+1];

        for (int i = 1; i <= len; i++) {
            arr[i] = code.charAt(i-1) - '0';
        }
    }

    private static void solve() {
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            if (arr[i] > 0) {
                dp[i] = (dp[i] + dp[i-1]) % 1_000_000;
            }

            int num = arr[i-1] * 10 + arr[i];

            if (num >= 10 && num <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % 1_000_000;
            }
        }
    }

    private static void printResult() {
        System.out.println(dp[len] % 1_000_000);
    }
}