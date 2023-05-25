import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {

    static int N;
    static int INF = Integer.MAX_VALUE;
    static int [] time;
    static int [] indegree;
    static int [] dp;
    static ArrayList<Integer>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        
        time = new int [N + 1];
        indegree = new int [N+1];
        dp = new int [N+1];
        
        
        list = new ArrayList [N + 1];
        
        for(int i=1; i<=N;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            
            time[i] = Integer.parseInt(st.nextToken());
            
            while(true){
                int idx = Integer.parseInt(st.nextToken());
                
                if(idx == -1){
                    break;
                }
                
                list[idx].add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =1;i<=N;i++){
            if(indegree[i] == 0){
                q.add(i);
                dp[i] = time[i];
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : list[cur]){
                dp[next] = Math.max(dp[next],dp[cur] + time[next]);
                if(--indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        
        for(int i=1; i<=N;i++){
            sb.append(dp[i]+"\n");
        }
        
        System.out.println(sb);
        
    }
    
}
