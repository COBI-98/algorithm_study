import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int n,m;
    static int a,b,c;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        list=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        st=new StringTokenizer(in.readLine());
        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());

        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost));
            list[to].add(new Node(from,cost));
        }

        long []dist1 = dijkstra(a);
        long []dist2 = dijkstra(b);
        long []dist3 = dijkstra(c);

        int vertex = 0;
        long compareDistance = 0;
        for (int i=1; i<=n; i++) {

            long minDistance = Math.min(dist1[i],Math.min(dist2[i],dist3[i]));

            if (minDistance == compareDistance) continue; 

            if (minDistance > compareDistance) {
                compareDistance = minDistance;
                vertex = i;
            }
        }

        System.out.println(vertex);

    }

    private static long[] dijkstra(int start) {

        long[] dist = new long[n+1];

        for (int i= 1; i<=n; i++) dist[i] = Long.MAX_VALUE;

        dist[start] = 0; 
        PriorityQueue<Node> pq = new PriorityQueue<>(); 

        pq.add(new Node(start,0)); 

        while(!pq.isEmpty()) {

            Node temp = pq.poll();

            int cur = temp.to;
            int distance = temp.cost;

            if (dist[cur] < distance) continue;

            for (int i = 0; i < list[cur].size(); i++) { 

                int nxt_distance = distance + list[cur].get(i).cost; 
                int nxt = list[cur].get(i).to; 

                if (dist[nxt] > nxt_distance) { 
                    dist[nxt] = nxt_distance; 
                    pq.add(new Node(nxt,nxt_distance));
                }

            }
        }

        return dist;
    }
    
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}