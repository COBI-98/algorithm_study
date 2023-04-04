import java.util.*;
class Solution {
    public static int[][] copyWires;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        copyWires = new int[n+1][n+1];
        
        for(int i = 0;i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            copyWires[a][b] = 1;
            copyWires[b][a] = 1;
        }
        
        for(int i = 0;i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            copyWires[a][b] = 0;
            copyWires[b][a] = 0;
            
            answer = Math.min(answer, bfs(n, i+1));
            
            copyWires[a][b] = 1;
            copyWires[b][a] = 1;
        }
        
        
        return answer;
    }
    private int bfs(int n, int start){
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checked = new boolean[n+1];
        
        queue.add(start);
        checked[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 1; i<=n; i++){
                if(copyWires[now][i]==1 && !checked[i]){
                    queue.add(i);
                    checked[i] = true;
                    cnt++;
                }
            }
        }
        
        return (int)Math.abs(n-2*cnt);
    }
}