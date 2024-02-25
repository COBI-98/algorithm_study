import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static final char EMPTY = '#';
    static final char BOMB = '*';
    static final char IMPOSSIBLE = '.';
    static int N;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= '0' && map[i][j] <= '9') {
                    check(i, j, map[i][j] - '0');
                }
            }
        }

        int cnt = getCnt();
        System.out.print(cnt);
    }
    
    private static int getCnt() {
        int cnt = 0;
        for (char[] line : map) {
            for (char c : line) {
                if (c == BOMB || c == EMPTY) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void check(int r, int c, int cnt) {
        int nr, nc;
        for (int i = 0; i < 8; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (isRange(nr, nc)) {
                continue;
            }

            if (map[nr][nc] == EMPTY) {
                if (cnt == 0) {
                    map[nr][nc] = IMPOSSIBLE;
                } else {
                    cnt--;
                    map[nr][nc] = BOMB;
                }
            } else if (map[nr][nc] == BOMB && cnt > 0) {
                cnt--;
            }
        }

    }

    private static boolean isRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }

}