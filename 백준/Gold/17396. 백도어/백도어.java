import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static final long INF = Long.MAX_VALUE;
    static long[] dist;
    static boolean[] isUnableMove;
    static boolean[] visited;
    static ArrayList<Node>[] adjList;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        printResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        isUnableMove = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isUnableMove[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
        }
        isUnableMove[N-1] = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (isUnableMove[a] || isUnableMove[b]) {
                continue;
            }
            adjList[a].add(new Node(b, t));
            adjList[b].add(new Node(a, t));
        }
    }

    private static void solve() {
        dist = new long[N];
        Arrays.fill(dist,INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        visited = new boolean[N];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) {
                continue;
            }

            visited[cur.idx] = true;

            for (Node node : adjList[cur.idx]) {
                if (!visited[node.idx] && dist[node.idx] > dist[cur.idx] + node.time) {
                    dist[node.idx] = dist[cur.idx] + node.time;
                    pq.add(new Node(node.idx, dist[node.idx]));
                }
            }
        }
    }

    private static void printResult() {
        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
    }

    static class Node implements Comparable<Node>{
        int idx;
        long time;
        public Node(int idx, long time){
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Long.compare(this.time, o.time);
        }
    }
}
