import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int X;
    static int result;
    static List<Node>[] adjList;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, cost));
        }

    }

    private static void solve() {
        for (int idx = 1; idx <= N; idx++) {
            if (idx == X){
                continue;
            }
            int go = dijkstra(idx, X);
            int back = dijkstra(X, idx);

            result = Math.max(result, go + back);
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (!visited[cur.idx]){
                visited[cur.idx] = true;

                for (Node next : adjList[cur.idx]) {
                    if (!visited[next.idx] && dist[next.idx] > dist[cur.idx] + next.cost){
                        dist[next.idx] = dist[cur.idx] + next.cost;
                        pq.offer(new Node(next.idx, dist[next.idx]));
                    }
                }
            }
        }

        return dist[end];
    }

    private static void printResult() {
        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
