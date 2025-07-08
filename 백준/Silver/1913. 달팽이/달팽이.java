import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int r = 0, c = 0, d = 0;
        int num = n * n;
        int kr = 0, kc = 0;

        while (num > 0) {
            map[r][c] = num;
            if (num == k) {
                kr = r + 1;
                kc = c + 1;
            }
            num--;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append(kr).append(" ").append(kc);

        System.out.print(sb);
    }
}