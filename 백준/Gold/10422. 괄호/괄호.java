import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static int L;
    static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        dp = new long[5_001];

        dp[0] = 1;
        dp[2] = 1;

        dynamicPrograming();

        for (int test_case = 0; test_case < T; test_case++) {
            L = Integer.parseInt(br.readLine());
            sb.append(dp[L]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dynamicPrograming() {

        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
                dp[i * 2] %= 1_000_000_007L;
           }
        }
    }


}
