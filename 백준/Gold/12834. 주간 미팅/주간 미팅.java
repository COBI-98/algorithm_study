import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int V;
    static int E;
    static int kist, CRFood;
    static int INF = Integer.MAX_VALUE;
    static int[] team;
    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        input();

        for (int member : team) {
            dijkstra(member);
            memberMinDistance(kist);
            memberMinDistance(CRFood);
        }
        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kist = Integer.parseInt(st.nextToken());
        CRFood = Integer.parseInt(st.nextToken());

        team = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            team[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, l));
            list.get(b).add(new Node(a, l));
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[V + 1];

        Arrays.fill(dist, INF);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.d > dist[cur.idx]) {
                continue;
            }

            for (Node target : list.get(cur.idx)) {
                if (dist[target.idx] > dist[cur.idx] + target.d) {
                    dist[target.idx] = dist[cur.idx] + target.d;
                    pq.offer(new Node(target.idx, dist[target.idx]));
                }
            }
        }

    }

    private static void memberMinDistance(int target) {
        if (dist[target] != INF) {
            ans += dist[target];
        } else {
            ans--;
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
}
