import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] dp;
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        
        Arrays.fill(dp[1],1);
        
        for(int i=2; i<=N;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
        
        for(int i=0;i<3;i++){
            sum += dp[N][i];
        }
        
        System.out.println(sum % 9901);
    }
    
}
