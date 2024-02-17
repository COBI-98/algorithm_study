import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int V;
    public static int E;
    public static int start;
    public static int [] dist;
    static final int INF = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static class Node{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E  = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(e,c));
        }

        dist = new int[graph.size()]; // 최소 비용을 저장할 배열
        Arrays.fill(dist, INF);

        dijkstra(start);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost , o2.cost)));

        pq.offer(new Node(start,0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            if (dist[curNode.idx] < curNode.cost){
                continue;
            }

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);

                if (dist[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    // 갱신된 경우에만 큐에 넣는다.
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }

            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}
