import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int T;
    static int K;
    static int S;
    static int [][] arr;
    static int [][] dp;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
      
        arr = new int[N+1][2];
        dp = new int[N+1][T+1];
        
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            
            arr[i][0] = K;
            arr[i][1] = S;
        }
        
        System.out.println(exam());
    }   
    
    public static int exam(){
        
        for(int t = 1; t<=T; t++){
            for(int i=1; i<=N;i++){
                dp[i][t] = dp[i-1][t];
                if(t - arr[i][0] >= 0){
                    dp[i][t] = Math.max(dp[i-1][t], arr[i][1] + dp[i-1][t-arr[i][0]]);
                }
            }
        }
        
        return dp[N][T];
    }
}
