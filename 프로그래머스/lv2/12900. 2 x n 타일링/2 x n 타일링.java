class Solution {
    public static int answer = 0;
    public static long [] dp ;
    public int solution(int n) {
        dp = new long [n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        answer = (int) tailing(n);
        return answer;
    }
    
    public static long tailing(int tail){
        if(tail < 3){
            return dp[tail] % 1_000_000_007;
        }
        for(int i = 3; i<=tail;i++){
            dp[i] = dp[i-1] + dp[i-2] % 1_000_000_007;
        }
        
        return dp[tail] % 1_000_000_007;
    }
}