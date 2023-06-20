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
    static int T;
    static int N;
    static int M;
    static int K;
    static int INF = Integer.MAX_VALUE;
    static int [] dist; // 거리
    static int [] room; // 친구들 방
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i < N+1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b,c));
                graph.get(b).add(new Node(a,c));
            }

            K = Integer.parseInt(br.readLine());
            room = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                room[i] = Integer.parseInt(st.nextToken());
            }


            dist = new int[N+1];
            int[] total = new int[N+1];
            for (int i = 0; i < K; i++) {
                Arrays.fill(dist,INF);
                dist[room[i]] = 0;
                dijkstra(room[i]);

                for (int j = 1; j < N + 1; j++) {
                    total[j] += dist[j];  // 방끼리(total[j]) 최단 거리(dist[j])를 더해줌
                }
            }

            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 1; i < N + 1; i++) {
                if (min > total[i]) {
                    min = total[i];
                    idx = i;
                }
            }
            
            sb.append(idx + "\n");
        }
        
        System.out.println(sb);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (dist[cur.d] < cur.w) continue;

            for (Node nn : graph.get(cur.d)) {
                if (dist[nn.d] > dist[cur.d] + nn.w) {
                    dist[nn.d] = dist[cur.d] + nn.w;
                    q.offer(new Node(nn.d, dist[nn.d]));
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int d;
        int w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

    }
}
