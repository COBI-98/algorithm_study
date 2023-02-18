import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[][] dist;
    public static int INF = Integer.MAX_VALUE;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static class loopy {
        int x;
        int y;
        int cost;

        public loopy(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            sb.append("Problem " + cnt + ": " + dijkstra());
            sb.append('\n');
            cnt++;

        }

        System.out.println(sb);
    }

    public static int dijkstra() {
        dist[0][0] = map[0][0];

        PriorityQueue<loopy> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        queue.offer(new loopy(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            loopy curLoopy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curLoopy.x + dx[i];
                int ny = curLoopy.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (dist[nx][ny] > dist[curLoopy.x][curLoopy.y] + map[nx][ny]){
                        dist[nx][ny] = dist[curLoopy.x][curLoopy.y] + map[nx][ny];

                        queue.offer(new loopy(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
