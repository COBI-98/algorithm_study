import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class tomato2 {
        int x;
        int y;
        int z;
        int day;

        public tomato2(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static int M;
    public static int N;
    public static int H;
    public static int[][][] map;
    public static int day;

    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static Queue<tomato2> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[M][N][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[k][j][i] = Integer.parseInt(st.nextToken());

                    if (map[k][j][i] == 1) {
                        queue.offer(new tomato2(k, j, i, 0));
                    }
                }
            }
        }

        bfs();
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            tomato2 t = queue.poll();
            day = t.day;

            for (int i = 0; i < 6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = 1;
                        queue.add(new tomato2(nx, ny, nz, day + 1));

                    }
                }
            }
        }

        if (!tomatoCheck()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    public static boolean tomatoCheck() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[k][j][i] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
