class Solution {
    static boolean[] visited;
    static int[] nodeInfo;
    static int[][] edgeInfo;
    static int maxSheep = Integer.MIN_VALUE;

    public int solution(int[] info, int[][] edges) {
        this.nodeInfo = info;
        this.edgeInfo = edges;
        
        visited = new boolean[info.length];
        visited[0] = true;
        
        dfs(1, 0);
        
        return maxSheep;
    }

    public void dfs(int sheep, int wolf) {
        if (sheep > wolf) {
            maxSheep = Math.max(maxSheep, sheep);
        } else {
            return;
        }

        for (int[] edge : edgeInfo) {
            int parent = edge[0];
            int child = edge[1];
            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                if (nodeInfo[child] == 0) {
                    dfs(sheep + 1, wolf);
                } else {
                    dfs(sheep, wolf + 1);
                }
                visited[child] = false;
            }
        }
    }
}