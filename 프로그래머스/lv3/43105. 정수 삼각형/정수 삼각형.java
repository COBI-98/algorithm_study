class Solution {
    public static int answer = Integer.MIN_VALUE;
    public static int [][] dp;
    public static int height;
    public int solution(int[][] triangle) {
        height = triangle.length;
        int x = triangle[2].length;
        
        dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        
        return operator(height,triangle);
    }
    
    public static int operator(int height, int[][] triangle){
        
        for(int i=1; i<height;i++){
            
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            for(int j=1; j<=i;j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) +triangle[i][j];
            }
        }
        
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[height - 1][i]);
        }
        
        return answer;
    }
}