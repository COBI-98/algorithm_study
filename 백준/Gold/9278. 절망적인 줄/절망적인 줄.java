import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            try {
                String testCase = br.readLine();
                int N = testCase.length();
                int half = N / 2;

                dp = new int[N][half + 1];

                if (testCase.charAt(0) != ')') {
                    dp[0][1] = 1;
                }else{
                    sb.append(0).append("\n");
                    continue;
                }

                dynamicPrograming(testCase, N, half);

                sb.append(dp[N - 1][0] % 1_000_000).append("\n");
            } catch (Exception e) {
                break;
            }
        }

        System.out.print(sb);
    }

    private static void dynamicPrograming(String testCase, int N, int half) {

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= half; j++) {
                char c = testCase.charAt(i);
                if (j != 0 && c != ')') {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j != half && c != '(') {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= 1_000_000;
            }
        }

    }
}
