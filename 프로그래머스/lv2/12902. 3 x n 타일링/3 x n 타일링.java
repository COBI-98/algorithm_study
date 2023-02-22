class Solution {
    public static long [] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        
        answer = (int) tailing(n);
        
        return answer;
    }
    
    public static long tailing(int x){
        if(x%2 == 1){
            return dp[x] % 1_000_000_007L;
        }
        
        for(int i=4; i<=x; i += 2){
            dp[i] = dp[i-2] * dp[2]% 1_000_000_007L ;
            for(int j=i-4; j>=0; j -= 2){
                dp[i] += (dp[j]*2) % 1_000_000_007L;
            }
        }
        
        return dp[x]  % 1_000_000_007L;
    }
}