import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int dp[][];
    static List<Integer> noList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][200];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 200; j++) {
                dp[i][j] = INF;
            }
        }

        if(M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            noList.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(dfs(1, 0));
    }

    static int dfs(int day, int coupon) {
        if(day > N)
            return 0;

        if(dp[day][coupon] < Integer.MAX_VALUE) {
            return dp[day][coupon];
        }

        if(noList.contains(day)) {
            return dp[day][coupon] = dfs(day + 1, coupon);
        }

        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon) + 10000);
        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 3, coupon + 1) + 25000);
        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 5, coupon + 2) + 37000);

        if(coupon >= 3) {
            dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon - 3));
        }

        return dp[day][coupon];
    }

}