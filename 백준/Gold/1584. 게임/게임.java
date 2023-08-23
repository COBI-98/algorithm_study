import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int WARNING_ZONE = 1;
    static int DEATH_ZONE = -1;
    static int[][] zone = new int[501][501];
    static boolean[][] visit = new boolean[501][501];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs() ? zone[500][500] : -1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            setZone(x1, y1, x2, y2, WARNING_ZONE);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            setZone(x1, y1, x2, y2, DEATH_ZONE);
        }
    }

    private static void setZone(int x1, int y1, int x2, int y2, int setting) {
        for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
            for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                zone[j][k] = setting;
            }
        }
    }

    private static boolean bfs() {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, 0, 0));
        visit[0][0] = true;
        zone[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cost = cur.cost;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (isRange(nextX, nextY)) {
                    if (!visit[nextX][nextY] && zone[nextX][nextY] != DEATH_ZONE) {
                        visit[nextX][nextY] = true;
                        zone[nextX][nextY] += cost;
                        queue.add(new Node(nextX, nextY, zone[nextX][nextY]));
                    }
                }
            }
        }

        return visit[500][500];
    }

    private static boolean isRange(int nextX, int nextY) {
        return nextX >= 0 && nextX < 501 && nextY >= 0 && nextY < 501;
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
}