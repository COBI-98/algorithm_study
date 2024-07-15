import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int T;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[j] != 'O') {
                    map[i][j] = -1;
                }
            }
        }
    }

    private static void solve() throws IOException {
        int time = 0;

        time++;
        while (true) {
            if (time >= T) {
                break;
            }

            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == -1) {
                        map[i][j] = time;
                    }
                }
            }
            if (time >= T) {
                break;
            }

            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == (time - 3)) {
                        bomb(i, j, time - 3);
                    }
                }
            }
        }
    }

    private static void bomb(int x, int y, int t) {
        map[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (!isRange(nx, ny)) {
                continue;
            }
            
            if (map[nx][ny] != t) {
                map[nx][ny] = -1;
            }
        }
    }

    private static boolean isRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] == -1 ? "." : "O");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}