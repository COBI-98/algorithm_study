import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long dp[] = new long[100001];
 
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
 
        for(int i = 6; i < dp.length; i++){
            dp[i] = (dp[i - 6] + dp[i - 4] + dp[i - 2]) % 1_000_000_009;
        }
 
        int test = Integer.parseInt(br.readLine());
 
        while(test-- > 0){
            int num = Integer.parseInt(br.readLine());
 
            System.out.println(dp[num]);
        }
    }
}