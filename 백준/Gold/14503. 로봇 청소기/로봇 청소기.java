import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // x 좌표
        int c = Integer.parseInt(st.nextToken()); // y 좌표 vo
        int d = Integer.parseInt(st.nextToken()); // 방향 vo

        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;

        dfs(r,c,d);

        System.out.println(count);
    }

    public static void dfs(int x, int y, int way){

        if (arr[x][y] == 0) {
            arr[x][y] = 2;
            count++;
        }

        // 2. 왼쪽방향부터 차례대로 탐색을 진행한다.
        boolean flag = false;
        int origin = way;
        for (int i = 0; i < 4; i++) {
            int next_d = (way + 3) % 4;
            int next_r = x + dx[next_d];
            int next_c = y + dy[next_d];

            if (next_r > 0 && next_c > 0 && next_r < N && next_c < M) {
                if (arr[next_r][next_c] == 0) {   // 아직 청소하지 않은 공간이라면
                    dfs(next_r, next_c, next_d);
                    flag = true;
                    break;
                }
            }
            way = (way + 3) % 4;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if (!flag) {
            int next_d = (origin + 2) % 4;
            int next_br = x + dx[next_d];
            int next_bc = y + dy[next_d];

            if (next_br > 0 && next_bc > 0 && next_br < N && next_bc < M) {
                if (arr[next_br][next_bc] != 1) {
                    dfs(next_br, next_bc, origin); // 바라보는 방향 유지한 채 후진
                }
            }
        }


    }
}
