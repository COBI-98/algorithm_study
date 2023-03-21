
class Solution {
    public static int m;
    public static boolean [] visited;
    public static int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        m = dungeons.length;
        visited = new boolean[m];
        
        dfs(0,k,dungeons);
        
        return answer;
    }
    
    public static void dfs(int depth, int copyK, int[][] dungeons){
        
        for(int i=0; i<m; i++){
            
            if(!visited[i] && dungeons[i][0] <= copyK){
                visited[i] = true;
                dfs(depth+1, copyK - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer,depth);
    }
}