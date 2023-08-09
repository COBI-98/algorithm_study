import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[][] dustMap;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<airCleaner> list;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < T; i++) {
            dustMap = new int[R][C];

            diffuseDustInMap();
            combineMap();
            airCleanerWorkInMap();
        }

        System.out.println(count() + 2);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    list.add(new airCleaner(i, j));
                }
            }
        }
    }

    private static void diffuseDustInMap() {
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (map[j][k] >= 5) {
                    int diffuseDust = map[j][k] / 5;

                    map[j][k] -= diffusion(j, k, diffuseDust);
                }
            }
        }
    }

    private static int diffusion(int x, int y, int diffuseDust) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isRange(nx, ny)) {
                continue;
            }

            if (isAirCleanerRange(nx, ny)) {
                continue;
            }

            dustMap[nx][ny] += diffuseDust;
            sum += diffuseDust;
        }

        return sum;
    }


    private static void combineMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                map[i][j] += dustMap[i][j];
            }
        }
    }

    private static void airCleanerWorkInMap() {
        int top = list.get(0).x;

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0;

        int bottom = list.get(1).x;

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0; 
    }
    
    private static boolean isRange(int nx, int ny) {
        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
            return true;
        }
        return false;
    }

    private static boolean isAirCleanerRange(int nx, int ny) {
        airCleaner robot1 = list.get(0);
        airCleaner robot2 = list.get(1);
        if (nx == robot1.x && ny == robot1.y) {
            return true;
        }

        if (nx == robot2.x && ny == robot2.y) {
            return true;
        }
        return false;
    }

    public static int count() {
        int temp = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp += map[i][j];
            }
        }
        return temp;
    }

    static class airCleaner {
        int x;
        int y;

        public airCleaner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
