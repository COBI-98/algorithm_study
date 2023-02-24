class Solution {
    public static int answer = 0;
    public static boolean [] visited ;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[computers.length];
        
        for(int i=0; i<computers.length;i++){
            if(!visited[i]){
                answer++;
                dfs(i,computers);
            }
        }
        
        return answer;
    }   
    public static void dfs(int node, int [][] computers){
        
        visited[node] = true;
        
        for(int i=0; i<computers.length;i++){
            if(!visited[i] && computers[node][i] == 1){
                dfs(i,computers);
            }
        }
    }
}