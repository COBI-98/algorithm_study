import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int N; // n각형 지도
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static boolean[][] visit;
    public static ArrayList<Integer> arr = new ArrayList<>(); // 단지내 집의 수를 담고있는 배열
    public static int[][] map;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    arr.add(cnt);
                }
            }
        }
        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void dfs(int x, int y) {

//        if(!visit[x][y]){
//            return;
//        }

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) { //한 단지 내에서 dfs 호출
                if (map[nx][ny] == 1 && !visit[nx][ny]) {

                    dfs(nx, ny);
                    cnt++;
                }
            }
        }
    }
}
