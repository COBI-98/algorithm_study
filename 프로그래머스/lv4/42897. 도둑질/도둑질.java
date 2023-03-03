class Solution {
    public static int [][] dp ;
    public static int m;
    public static int answer;
    // 평범한 배낭
    public int solution(int[] money) {
        m = money.length;
        
        dp = new int[2][m];
        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][0] = 0;
        dp[1][1] = money[1];
        
        answer = dynamic(m, money);
        
        
        return answer;
    }
    
    public static int dynamic(int x,int [] money){
        
        for(int i=2; i<m;i++){
            dp[0][i] = Math.max(dp[0][i-2]+money[i],dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2]+money[i],dp[1][i-1]);    
        }
        
        
        return Math.max(dp[0][x-2], dp[1][x-1]);
    }
}