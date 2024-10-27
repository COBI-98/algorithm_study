import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static final int MOD = 100999;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        dp = new int[2001][2001];
        for (int i = 0; i < 2001; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        int t = Integer.parseInt(br.readLine());
        int n;
        int answer = 0;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            answer = getCnt(n, n);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int getCnt(int x, int m) {
        if (x < 0 || m < 0) {
            return 0;
        } else if (dp[x][m] != -1) {
            return dp[x][m];
        } else if (x == 0) {
            return dp[x][m] = 1;
        }
        int cnt = 0;
        cnt += (getCnt(x, m - 1) + getCnt(x - m, m - 1)) % MOD;
        return dp[x][m] = cnt;
    }

}