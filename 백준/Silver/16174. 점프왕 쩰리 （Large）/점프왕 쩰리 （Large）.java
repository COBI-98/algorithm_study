import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}};
    static boolean answer;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        init();
        dfs(0, 0, map[0][0]);
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
    }

    private static void dfs(int r, int c, int value) {
        if (map[r][c] == -1) {
            answer = true;
            return;
        }

        if (r < 0 || c < 0 || r > N - 1 || c > N - 1) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = r + dir[i][0] * value;
            int nc = c + dir[i][1] * value;
            if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, map[nr][nc]);
        }
    }

    private static void printResult() {
        if (answer) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
}