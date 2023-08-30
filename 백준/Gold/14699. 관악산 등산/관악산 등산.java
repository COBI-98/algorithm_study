import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int[] height;
    static ArrayList<Integer>[] adjList;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) height[i] = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            adjList[from].add(to);
            adjList[to].add(from);
        }

        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        for(int i = 1; i < N + 1; i++) {
            dijkstra(i);
        }
        
        for(int i = 1; i < N + 1; i++) {
            System.out.println(dp[i]);
        }

    }

    static int dijkstra(int cur){

        int max = 0;
        
        for(int i = 0; i < adjList[cur].size(); i++){
            int next = adjList[cur].get(i);

            if(height[next] > height[cur]){
                if(dp[next] == -1) {
                    max = Math.max(max, dijkstra(next));
                } else {
                    max = Math.max(max, dp[next]);
                }
            }
        }
        
        return dp[cur] = max + 1;
    }
    
}