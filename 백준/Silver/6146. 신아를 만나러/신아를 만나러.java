import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int endX;
    static int endY;
    static boolean[][] isPool;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        endX = endX + 500;
        endY = endY + 500;

        isPool = new boolean[1001][1001];
        visited = new boolean[1001][1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            A += 500;
            B += 500;

            isPool[A][B] = true;

        }

        System.out.println(bfs());
    }

     private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(500, 500, 0));
        visited[500][500] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == endX && cur.y == endY) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isRange(nx, ny)) {
                    continue;
                }



                if (!isPool[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isRange(int x, int y) {
        if (x > 1000 || y > 1000 || x < 0 || y < 0) {
            return true;
        }
        return false;
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
