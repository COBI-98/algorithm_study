import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h, w, jump;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        h = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        map = new int[h][w];
        visit = new boolean[h][w];

        StringTokenizer st;
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        jump = Integer.parseInt(br.readLine());

        if (map[0][0] != map[h - 1][w - 1]) {
            sb.append("DEAD");
        } else {
            function(0, 0);

            if (visit[h - 1][w - 1]) {
                sb.append("ALIVE");
            } else {
                sb.append("DEAD");
            }
        }

        System.out.println(sb);
    }


    private static void function(int y, int x) {
        int ny = y;
        int nx = x;
        int dis;
        visit[ny][nx] = true;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dis = Math.abs(ny - i) + Math.abs(nx - j);

                if (!visit[i][j] && dis <= jump && map[ny][nx] == map[i][j]) {
                    function(i, j);
                }
            }
        }
    }
}