import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static final int INF = 1_000_000_000;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int N;
    static int E;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        if (E == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());

        int via1 = Integer.parseInt(st.nextToken());
        int via2 = Integer.parseInt(st.nextToken());

        int case1 = 0, case2 = 0;

        case1 += dijkstra(1, via1);
        case1 += dijkstra(via1, via2);
        case1 += dijkstra(via2, N);

        case2 += dijkstra(1, via2);
        case2 += dijkstra(via2, via1);
        case2 += dijkstra(via1, N);

        if (case1 >= INF && case2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(case1, case2));
        }

    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > dist[curNode.to] + adjNode.weight) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
}
    