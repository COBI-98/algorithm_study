import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;

    public static int[][] paper;
    public static boolean[][] visit;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j,paper[i][j],1);
                    visit[i][j] = false;
                }
            }
        }

        System.out.println(max);

    }

    public static void dfs(int x,int y,int sum, int count) {

        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visit[nx][ny]) {

                    if (count == 2){
                        visit[nx][ny] = true;
                        dfs(x,y,sum+paper[nx][ny],count+1);
                        visit[nx][ny] = false;
                    }
                    visit[nx][ny] = true;
                    dfs(nx, ny, sum+paper[nx][ny],count+1);
                    visit[nx][ny] = false;
                }
            }
        }

    }



}
