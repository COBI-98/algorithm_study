import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;

    public static int x;
    public static int y;
    public static int[][] map;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int K;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice dic = new dice(0, 0, 0, 0, 0, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int move = Integer.parseInt(st.nextToken()) - 1;

            // 일단 굴리기
            x = x + dx[move];
            y = y + dy[move];
            if (x < 0 || y < 0 || x >= N || y >= M) {
                // 범위를 벗어나게 되면
                x -= dx[move];
                y -= dy[move];
                continue;
                // 다음 조건으로 넘어간다.
            }

            if (move == 0) {
                // 동쪽으로 굴리기
                int tmp = dic.left;
                dic.left = dic.now;
                dic.now = dic.right;
                dic.right = dic.nowtop;
                dic.nowtop = tmp;
            } else if (move == 1) {
                // 서쪽으로 굴리기
                int tmp = dic.left;
                dic.left = dic.nowtop;
                dic.nowtop = dic.right;
                dic.right = dic.now;
                dic.now = tmp;
            } else if (move == 2) {
                // 북쪽으로 굴리기
                int tmp = dic.now;
                dic.now = dic.top;
                dic.top = dic.nowtop;
                dic.nowtop = dic.bottom;
                dic.bottom = tmp;
            } else if (move == 3) {
                // 남쪽으로 굴리기
                int tmp = dic.now;
                dic.now = dic.bottom;
                dic.bottom = dic.nowtop;
                dic.nowtop = dic.top;
                dic.top = tmp;
            }

            // 주사위를 굴렸을 때, 이동하는 칸에 쓰여있는 수가 0이면 주사위의 바닥면에 쓰여있는 수가 복사된다.
            if (map[x][y] == 0) {
                map[x][y] = dic.now;
            } else {
                // 아닐 경우에는 반대로
                dic.now = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dic.nowtop).append("\n");
        }
        System.out.println(sb);
    }
}

class dice {
    int now, left, right, top, bottom, nowtop;

    public dice(int now, int left, int right, int top, int bottom, int nowtop) {
        super();
        this.now = now;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.nowtop = nowtop;
    }

    @Override
    public String toString() {
        return "jusawe [now=" + now + ", left=" + left + ", right=" + right + ", top=" + top + ", bottom=" + bottom
                + ", nowtop=" + nowtop + "]";
    }

}