import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[][] maze;
    public static int count;
    public static boolean[][] visit;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};


    public static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String st2 = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = st2.charAt(j) - '0';
            }
        }
        visit[0][0] = true;
        bfs(0,0);
        System.out.println(maze[N-1][M-1]);

    }

    public static void bfs(int x, int y) {
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (visit[nextX][nextY] || maze[nextX][nextY] == 0)
                    continue;

                queue.add(new int[] {nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                visit[nextX][nextY] = true;
            }
        }
    }
}
