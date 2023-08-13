import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static final int GAME_ROW = 5;
    static final int GAME_COL = 9;
    static int pinResult;
    static int moveResult;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            if (test_case != 0) {
                br.readLine();
            }

            map = new int[GAME_ROW][GAME_COL];
            int pin = 0;

            for (int i = 0; i < GAME_ROW; i++) {
                String str = br.readLine();

                for (int j = 0; j < GAME_COL; j++) {
                    if (str.charAt(j) == '#') {
                        map[i][j] = 2;
                    } else if (str.charAt(j) == 'o') {
                        map[i][j] = 1;
                        pin++;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            pinResult = pin;

            for (int i = 0; i < GAME_ROW; i++) {
                for (int j = 0; j < GAME_COL; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j, pin, 0);
                    }
                }
            }

            sb.append(pinResult + " " + moveResult + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y, int pin, int mv) {
        if (pin <= pinResult) {
            pinResult = pin;
            moveResult = mv;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && map[nx][ny] == 1) {
                int next_x = nx + dx[i];
                int next_y = ny + dy[i];

                if (isRange(next_x, next_y) && map[next_x][next_y] == 0) {
                    map[x][y] = 0;
                    map[nx][ny] = 0;
                    map[next_x][next_y] = 1;

                    for (int j = 0; j < GAME_ROW; j++) {
                        for (int k = 0; k < GAME_COL; k++) {
                            if (map[j][k] == 1) {
                                dfs(j, k, pin - 1, mv + 1);
                            }
                        }
                    }

                    map[x][y] = 1;
                    map[nx][ny] = 1;
                    map[next_x][next_y] = 0;
                }
            }
        }


    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < GAME_ROW && y >= 0 && y < GAME_COL;
    }
    
}
