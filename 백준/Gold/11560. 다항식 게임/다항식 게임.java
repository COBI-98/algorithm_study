import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 20;
    static int K, N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        calculatePolynomial();

        StringTokenizer st ;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            sb.append(dp[K][N]).append("\n");
        }
        System.out.println(sb);
    }

    static void calculatePolynomial(){

        dp = new long[MAX + 1][(MAX * (MAX + 1) / 2) + 1];
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int k = 2; k <= MAX; k++) {
            
            for (int i = 0; i < dp[k - 1].length; i++) {
                if (dp[k - 1][i] != 0){
                    for (int j = 0; j <= k; j++) {
                        dp[k][j + i] = dp[k][j + i] + dp[k - 1][i];
                    }
                }
            }
        }
    }
}