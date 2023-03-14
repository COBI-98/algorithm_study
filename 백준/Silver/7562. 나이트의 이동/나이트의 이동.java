import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int l;
    public static int[][] N;
    public static boolean[][] visited;

    static class Knight {
        int x;
        int y;
        int cnt;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
            cnt = 0;
        }

        public Knight(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            N = new int[l][l];
            visited = new boolean[l][l];
            Knight[] knights = new Knight[2];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                knights[j] = new Knight(x, y);
            }
            sb.append(bfs(knights));
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int bfs(Knight[] knights) {
        Queue<Knight> q = new LinkedList<>();
        q.offer(knights[0]);
        visited[knights[0].x][knights[0].y] = true;

        while (!q.isEmpty()) {
            Knight k = q.poll();
            if (k.x == knights[1].x && k.y == knights[1].y) {
                return k.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + k.x;
                int ny = dy[i] + k.y;

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Knight(nx, ny, k.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

}
