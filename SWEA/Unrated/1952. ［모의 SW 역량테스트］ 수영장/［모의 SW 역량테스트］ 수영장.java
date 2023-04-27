import java.util.*;
import java.io.*;

class Solution{
    static int T;
    static int [] amountList; // 이용권금액리스트
    static int [] month;
    static int [] dp;
    static int result;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
     	T = Integer.parseInt(br.readLine());   
     
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
            amountList = new int [4];
            dp = new int [13];
            month = new int [13];
            for(int i = 0; i<4; i++){
            	amountList[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for(int i=1; i<=12;i++){
            	month[i] = Integer.parseInt(st.nextToken());
            }
            result = waterPool(12);
            sb.append("#"+test_case+" "+result+"\n");
		}
        System.out.println(sb);
	}
    
    public static int waterPool(int x){
    	if(dp[x] > 0){
            return dp[x];
        }
        
        for(int i = 1; i <=x; i++){
        	dp[i] = Math.min(dp[i-1] + month[i] * amountList[0], dp[i-1] + amountList[1]);
            
            if( i>=3){
            	dp[i] = Math.min(dp[i], dp[i-3] + amountList[2]);
            }
        }
        
        return Math.min(dp[x], amountList[3]);
    }
}