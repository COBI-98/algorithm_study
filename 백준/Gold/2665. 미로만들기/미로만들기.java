import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int INF = Integer.MAX_VALUE;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
            Arrays.fill(dist[i], INF);
        }
    }

    private static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nChange = cur.change;

                if (!isRange(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    nChange++;
                }

                if (dist[nx][ny] > nChange) {
                    dist[nx][ny] = nChange;
                    pq.add(new Node(nx, ny, nChange));
                }

            }
        }
    }
    
    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static void printResult() {
        System.out.println(dist[n-1][n-1]);
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int change;

        public Node(int x, int y, int change) {
            this.x = x;
            this.y = y;
            this.change = change;
        }

        @Override
        public int compareTo(Node o) {
            return this.change - o.change;
        }
    }
}
