import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int S;
    static int p;
    static int q;
    static int[] k;
    static final long INF = Long.MAX_VALUE;

    static List<List<Node>> adjList = new ArrayList<>();
    static int[] dangerVisited;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        init();
        checkedDangerCity();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        k = new int[K];

        for (int i = 0; i < K; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }

        dist = new long[N + 1];
        dangerVisited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Node(to, 0));
            adjList.get(to).add(new Node(from, 0));
        }
        
    }

    private static void checkedDangerCity() {
        Queue<Danger> queue = new LinkedList<>();
        for (int i = 0; i < k.length; i++) {
            queue.add(new Danger(k[i], 0));
            dangerVisited[k[i]] = 1;
        }

        while (!queue.isEmpty()) {
            Danger cur = queue.poll();
            int cur_depth = cur.depth;

            if (cur_depth >= S) {
                continue;
            }

            for (Node next : adjList.get(cur.idx)) {
                if (dangerVisited[next.idx] == 0) {
                    dangerVisited[next.idx] = 2;
                    queue.add(new Danger(next.idx, cur_depth + 1));
                }
            }
        }

    }

    private static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        Arrays.fill(dist, INF);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.idx == N) {
                continue;
            }

            for (Node next : adjList.get(cur.idx)) {
                if (dangerVisited[next.idx] == 0) {
                    if (dist[next.idx] > dist[cur.idx] + p) {
                        dist[next.idx] = dist[cur.idx] + p;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                } else if (dangerVisited[next.idx] == 2) {
                    if (dist[next.idx] > dist[cur.idx] + q) {
                        dist[next.idx] = dist[cur.idx] + q;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }
        }

        if (dangerVisited[N] == 0) {
            dist[N] -= p;
        } else if (dangerVisited[N] == 2) {
            dist[N] -= q;
        }

        System.out.println(dist[N]);
    }

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static class Danger {
        int idx;
        int depth;

        public Danger(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
