import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D, maxCount, enemyCount;
    static int[][] map, copyMap;
    static int[] archerList;
    static Queue<Node> queue = new LinkedList<>();
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        archerList = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        combination(0, 0);
        System.out.println(maxCount);
    }

    private static void combination(int idx, int depth) {
        if (depth == 3) {
            enemyCount = 0;
            copyMap = new int[N + 1][M];
            copyMap();
            game();
            maxCount = Math.max(maxCount, enemyCount);
            return;
        }

        for (int i = idx; i < M; i++) {
            archerList[depth] = i;
            combination(i + 1, depth + 1);
        }

    }

    private static void copyMap() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    private static void game() {
        for (int i = 0; i < N; i++) {
            killNearEnemy();
            forwardEnemy();
        }
    }

    private static void forwardEnemy() {
        for (int j = 0; j < M; j++) {
            for (int i = N - 2; i >= 0; i--) {
                copyMap[i + 1][j] = copyMap[i][j];
            }
        }
        for (int j = 0; j < M; j++) {
            copyMap[0][j] = 0;
            copyMap[N][j] = 0;
        }
    }

    private static void killNearEnemy() {
        Queue<Node> killQueue = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            int x = N;
            int y = archerList[i];
            queue.offer(new Node(x, y));
            boolean[][] visited = new boolean[N + 1][M];
            int degree = 0;
            while (!queue.isEmpty()) {
                if (degree == D) {
                    queue.clear();
                    break;
                }
                int size = queue.size();
                Loop:
                for (int j = 0; j < size; j++) {
                    Node cur = queue.poll();

                    for (int k = 0; k < 3; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (0 > nx || 0 > ny || ny >= M || visited[nx][ny]) {
                            continue;
                        }

                        if (copyMap[nx][ny] == 1) {
                            killQueue.add(new Node(nx, ny));
                            queue.clear();
                            break Loop;
                        }

                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
                degree++;
            }
        }
        while (!killQueue.isEmpty()) {
            Node cur = killQueue.poll();

            if (copyMap[cur.x][cur.y] == 1) {
                copyMap[cur.x][cur.y] = 0;
                enemyCount += 1;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}