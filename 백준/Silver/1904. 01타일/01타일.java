import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int [] dp;
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i =2; i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        
        System.out.println(dp[N]);
    }
    
}
