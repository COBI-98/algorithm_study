class Solution {
    public static int answer = 0;
    public int solution(int[][] sizes) {
        
        for(int i=0; i<sizes.length;i++){
            int x = sizes[i][0];
            int y = sizes[i][1];
            if(x < y) {
                sizes[i][0] = y;
                sizes[i][1] = x;
            }
        }
        
        int xMax = sizes[0][0];
        int yMax = sizes[0][1];
        
        for(int i = 1; i<sizes.length;i++){
            xMax = Math.max(xMax,sizes[i][0]);
            yMax = Math.max(yMax,sizes[i][1]);
        }
        
        answer = xMax * yMax;
        
        return answer;
    }
}