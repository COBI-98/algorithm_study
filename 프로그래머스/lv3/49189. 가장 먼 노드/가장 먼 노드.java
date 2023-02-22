import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        boolean visited[]= new boolean[n+1];
        
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        for(int i=1; i<=n; i++) {
        	Collections.sort(list.get(i));
        }
        
        //bfs
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(1);
        visited[1]=true;
        int que_size, node;
        
        while(!queue.isEmpty()){
            que_size= queue.size();
            for(int i=0; i<que_size; i++){
                node= queue.poll();
                for(int j=0; j<list.get(node).size(); j++){
                    if(!visited[list.get(node).get(j)]){
                        visited[list.get(node).get(j)]=true;
                        queue.offer(list.get(node).get(j));
                    }
                }
            }
            answer=que_size;
        }
        return answer;
    }
}