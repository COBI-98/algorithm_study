import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static final int INF = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
            Arrays.fill(dist[i], INF);
        }

        dijkstra();

        System.out.println(dist[N-1][M-1]);
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nBroken = cur.broken;

                if (!isRange(nx, ny)) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    nBroken++;
                }

                if (dist[nx][ny] > nBroken) {
                    dist[nx][ny] = nBroken;
                    pq.add(new Node(nx, ny, nBroken));
                }

            }
        }

        return 0;
    }

    private static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < N && y < M) {
            return true;
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int broken;

        public Node(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }

        @Override
        public int compareTo(Node o) {
            return this.broken - o.broken;
        }
    }
}
