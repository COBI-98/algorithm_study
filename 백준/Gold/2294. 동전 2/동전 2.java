import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int k;
    public static int [] coin;
    public static int [] dp;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n+1];
        dp = new int[k+1];

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(coinValue());
    }

    public static int coinValue(){
        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j] ,dp[j - coin[i]]+1);
            }
        }

        if (dp[k] == 100001) {
            dp[k] = -1;
        }


        return dp[k];
    }
}
