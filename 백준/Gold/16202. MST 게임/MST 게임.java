import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            pq.offer(new Node(from, to, i));
        }

        int idx = 0;
        for (int i = 0; i < K; i++) {

            nodes = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                nodes[j] = j;
            }

            int cnt = 0, sum = 0;
            PriorityQueue<Node> edge = new PriorityQueue<>(pq);
            for (int j = 0; j < idx; j++) {
                edge.poll();
            }

            while (!edge.isEmpty()) {
                Node node = edge.poll();
                if (find(node.start) != find(node.end)) {
                    cnt++;
                    sum += node.cost;
                    union(node.start, node.end);
                }
            }
            idx++;
            if (cnt != N - 1) {
                sb.append(0)
                        .append(" ");
            } else {
                sb.append(sum)
                        .append(" ");
            }
        }
        System.out.println(sb);
    }

    static int find(int n) {
        if (nodes[n] != n) {
            nodes[n] = find(nodes[n]);
        }
        return nodes[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            nodes[a] = b;
        } else {
            nodes[b] = a;
        }
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}