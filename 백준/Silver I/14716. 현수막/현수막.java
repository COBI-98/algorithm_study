import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int cnt = 0;
    public static int[][] arr;
    public static boolean[][] visited;
    public static Deque<int[]> Q = new ArrayDeque<>();
    public static int[] di = {1, 0, -1, 0, -1, -1, 1, 1};
    public static int[] dj = {0, 1, 0, -1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nM = bf.readLine().split(" ");
        N = Integer.parseInt(nM[0]);
        M = Integer.parseInt(nM[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    Q.add(new int[]{i, j});
                    bfs();
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void bfs() {
        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            int r = now[0];
            int c = now[1];
            visited[r][c] = true;
            for (int i = 0; i < 8; i++) {
                int nr = r + di[i];
                int nc = c + dj[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 0 || visited[nr][nc]) continue;
                Q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}