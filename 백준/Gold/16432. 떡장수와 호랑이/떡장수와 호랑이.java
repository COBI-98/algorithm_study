import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] result;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N+1];

        result = new int[N+1];
        visited = new boolean[N+2][10];

        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            adjList[i] = new ArrayList<Integer>();
            
            int way = Integer.parseInt(st.nextToken());
            for(int j = 0; j<way; j++){
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1, 0);
        System.out.println(-1);

    }

    static void dfs(int idx, int prev){
        if(idx == N+1){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<N+1; i++){
                sb.append(result[i]).append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        for(int i = 1; i<10; i++){
            if(prev != i && !visited[idx+1][i] && adjList[idx].contains(i)){
                result[idx] = i;
                visited[idx+1][i] = true;
                dfs(idx+1, i);
            }
        }

    }

}