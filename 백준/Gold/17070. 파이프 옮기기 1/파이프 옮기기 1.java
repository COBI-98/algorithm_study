import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] map;
    static int [][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int [N][N];
        dp = new int [N][N][3]; // 방향 ㅡ \ |
        
        StringTokenizer st; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
     
        dp[0][1][0] = 1;
        
        System.out.println(movePipe());
    }
    
    private static int movePipe(){
        for(int i=0; i<N;i++){
            for(int j=2;j<N;j++){
                if(map[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1]; //가로     
                
                if(i == 0) continue;
                dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1]; // 세로   
                
                if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
                dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
   
        return dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]; 
    }
    
}