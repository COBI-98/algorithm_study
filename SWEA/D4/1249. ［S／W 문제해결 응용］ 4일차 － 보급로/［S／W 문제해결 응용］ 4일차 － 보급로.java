import java.util.*;
import java.io.*;

class Solution{
   static int N;
    static int ans;
    static boolean[][] visited;
    static int[][] map;
    static int[][] count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());

            ans = Integer.MAX_VALUE;
            map = new int[N][N];
            count = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(count[i], Integer.MAX_VALUE);
            }

            count[0][0] = 0;

            bfs();

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<point> q = new LinkedList<>();

        q.add(new point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            point temp = q.poll();

            if (temp.x == N - 1 && temp.y == N - 1) {
                if (ans > count[N - 1][N - 1]) {
                    ans = count[N - 1][N - 1];
                }
            }

            for (int k = 0; k < 4; k++) {
                int xx = temp.x + dx[k];
                int yy = temp.y + dy[k];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N) {
                    continue;
                }
                if (!visited[xx][yy] || count[xx][yy] > (count[temp.x][temp.y] + map[xx][yy])) {
                    visited[xx][yy] = true;
                    count[xx][yy] = count[temp.x][temp.y] + map[xx][yy];
                    q.offer(new point(xx, yy));
                }
            }
        }
    }
}