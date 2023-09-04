import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            System.exit(0);
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        boolean[] visited = new boolean[MAX];
        int min = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == K) {
                min = cur.cnt;
                break;
            }
            
            visited[cur.x] = true;
            if (cur.x * 2 < MAX && visited[cur.x * 2] == false) {
                pq.add(new Node(cur.x * 2, cur.cnt));
            }

            if (cur.x + 1 < MAX && visited[cur.x + 1] == false) {
                pq.add(new Node(cur.x + 1, cur.cnt + 1));
            }

            if (cur.x - 1 >= 0 && visited[cur.x - 1] == false) {
                pq.add(new Node(cur.x + -1, cur.cnt + 1));
            }
        }

        return min;
    }

    static class Node implements Comparable<Node> {
        int x;
        int cnt;

        public Node(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node i) {
            return Integer.compare(this.cnt, i.cnt);
        }
    }
    
}