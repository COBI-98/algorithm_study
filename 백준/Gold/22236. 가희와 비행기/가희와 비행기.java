import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int d = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
 
        long[][] dp = new long[4001][4001];
        dp[1][1] = 1;
        for(int i = 2; i < d; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) continue;
                else dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1] % m);
            }
        }
        System.out.println(dp[d - 1][1] % m);
    }
}