import java.util.*;
import java.io.*;
class Solution {
    
    public static int m;
    public static boolean [] visited;
    public static List<String> allRoute = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        m = tickets.length;
        visited = new boolean[m];
        
        dfs("ICN","ICN",tickets,0);
        
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == m){
            allRoute.add(route);
            return;
        }
        
        for(int i=0; i<m; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}