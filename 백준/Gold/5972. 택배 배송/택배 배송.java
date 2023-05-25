import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {

    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;
    static int dp [];
    static ArrayList<Node>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        list = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
        
            list[A].add(new Node(B,C));
            list[B].add(new Node(A,C));
        }
        
        dp = new int [N+1];
        
        Arrays.fill(dp ,INF);
        
        dijkstra(1);
        
        System.out.println(dp[N]);
    }
    
    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(start,0));
        dp[start] = 0;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(Node next : list[cur.d]){
                if(dp[next.d] > dp[cur.d] + next.cost){
                    dp[next.d] = dp[cur.d] + next.cost;
                    queue.add(new Node(next.d, dp[next.d]));
                }
            }
        }
    }
    
    static class Node{
        int d;
        int cost;
        public Node(int d, int cost){
            this.d = d;
            this.cost = cost;
        }
    }
}
