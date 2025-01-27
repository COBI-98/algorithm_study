import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC --> 0) {
            int N = Integer.parseInt(br.readLine());
            dp = new boolean[N+1][7];
            dp[0][1] = true;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String op1 = st.nextToken();
                int num1 = Integer.parseInt(st.nextToken());
                operate(op1, num1, i);
                String op2 = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());
                operate(op2, num2, i);
            }
            sb.append(dp[N][0]? "LUCKY": "UNLUCKY");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void operate(String op, int num, int i) {
        boolean isAdd = false;
        if (op.equals("+")) isAdd = true;
        for (int j = 0; j < 7; j++) if (dp[i][j]) {
            if (isAdd) dp[i + 1][(j + num) % 7] = true;
            else dp[i + 1][(j * num) % 7] = true;
        }
    }


}